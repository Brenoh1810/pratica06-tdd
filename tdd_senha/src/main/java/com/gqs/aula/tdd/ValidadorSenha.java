package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class ValidadorSenha {

    public static final int TAMANHO_MINIMO = 8;
    public static final int MINIMO_DIGITOS = 2;

    public static final String MSG_TAMANHO_MINIMO = "A senha deve ter pelo menos 8 caracteres";
    public static final String MSG_DIGITOS = "A senha deve conter pelo menos 2 dígitos";
    public static final String MSG_MAIUSCULA = "A senha deve conter pelo menos uma letra maiuscula";
    public static final String MSG_CARACTERE_ESPECIAL = "A senha deve conter pelo menos um caractere especial";

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();
        if (senha.length() < TAMANHO_MINIMO) {
            erros.add(MSG_TAMANHO_MINIMO);
        }
        if (contarDigitos(senha) < MINIMO_DIGITOS) {
            erros.add(MSG_DIGITOS);
        }
        if (!contem(senha, Character::isUpperCase)) {
            erros.add(MSG_MAIUSCULA);
        }
        if (!contem(senha, ValidadorSenha::ehCaractereEspecial)) {
            erros.add(MSG_CARACTERE_ESPECIAL);
        }
        return new ResultadoValidacao(erros);
    }

    private long contarDigitos(String senha) {
        return senha.chars().filter(Character::isDigit).count();
    }

    private boolean contem(String senha, IntPredicate regra) {
        return senha.chars().anyMatch(regra);
    }

    private static boolean ehCaractereEspecial(int caractere) {
        return !Character.isLetterOrDigit(caractere);
    }
}
