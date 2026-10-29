package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidadorSenha {

    public static final int TAMANHO_MINIMO = 8;
    public static final String MSG_TAMANHO_MINIMO = "A senha deve ter pelo menos 8 caracteres";

    public ResultadoValidacao validar(String senha) {
        if (senha.length() < TAMANHO_MINIMO) {
            return new ResultadoValidacao(Arrays.asList(MSG_TAMANHO_MINIMO));
        }
        int digitos = 0;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                digitos++;
            }
        }
        if (digitos < 2) {
            return new ResultadoValidacao(Arrays.asList("A senha deve conter pelo menos 2 dígitos"));
        }
        return new ResultadoValidacao(new ArrayList<>());
    }
}
