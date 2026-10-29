package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidadorSenha {

    public ResultadoValidacao validar(String senha) {
        if (senha.length() < 8) {
            return new ResultadoValidacao(Arrays.asList("A senha deve ter pelo menos 8 caracteres"));
        }
        return new ResultadoValidacao(new ArrayList<>());
    }
}
