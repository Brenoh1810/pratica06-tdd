package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class ValidadorSenha {

    public static final int TAMANHO_MINIMO = 8;
    public static final int MINIMO_DIGITOS = 2;

    public static final String MSG_TAMANHO_MINIMO = "A senha deve ter pelo menos 8 caracteres";
    public static final String MSG_DIGITOS = "A senha deve conter pelo menos 2 dígitos";
    public static final String MSG_MAIUSCULA = "A senha deve conter pelo menos uma letra maiuscula";

    public ResultadoValidacao validar(String senha) {
        if (senha.length() < TAMANHO_MINIMO) {
            return new ResultadoValidacao(Arrays.asList(MSG_TAMANHO_MINIMO));
        }
        if (contarDigitos(senha) < MINIMO_DIGITOS) {
            return new ResultadoValidacao(Arrays.asList(MSG_DIGITOS));
        }
        if (!contem(senha, Character::isUpperCase)) {
            return new ResultadoValidacao(Arrays.asList(MSG_MAIUSCULA));
        }
        if (!contem(senha, c -> !Character.isLetterOrDigit(c))) {
            return new ResultadoValidacao(Arrays.asList("A senha deve conter pelo menos um caractere especial"));
        }
        return new ResultadoValidacao(new ArrayList<>());
    }

    private long contarDigitos(String senha) {
        return senha.chars().filter(Character::isDigit).count();
    }

    private boolean contem(String senha, IntPredicate regra) {
        return senha.chars().anyMatch(regra);
    }
}
