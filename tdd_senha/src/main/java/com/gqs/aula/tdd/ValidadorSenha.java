package com.gqs.aula.tdd;

import java.util.ArrayList;

public class ValidadorSenha {

    public ResultadoValidacao validar(String senha) {
        return new ResultadoValidacao(new ArrayList<>());
    }
}
