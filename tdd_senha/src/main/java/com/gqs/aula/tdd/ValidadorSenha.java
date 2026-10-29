package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidadorSenha {

    public static final int TAMANHO_MINIMO = 8;
    public static final int MINIMO_DIGITOS = 2;

    public static final String MSG_TAMANHO_MINIMO = "A senha deve ter pelo menos 8 caracteres";
    public static final String MSG_DIGITOS = "A senha deve conter pelo menos 2 dígitos";

    public ResultadoValidacao validar(String senha) {
        if (senha.length() < TAMANHO_MINIMO) {
            return new ResultadoValidacao(Arrays.asList(MSG_TAMANHO_MINIMO));
        }
        if (contarDigitos(senha) < MINIMO_DIGITOS) {
            return new ResultadoValidacao(Arrays.asList(MSG_DIGITOS));
        }
        return new ResultadoValidacao(new ArrayList<>());
    }

    private long contarDigitos(String senha) {
        return senha.chars().filter(Character::isDigit).count();
    }
}
