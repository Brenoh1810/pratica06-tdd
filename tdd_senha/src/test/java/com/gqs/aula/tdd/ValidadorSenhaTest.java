package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    @Test
    void deveAceitarSenhaQueAtendeTodasAsRegras() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao resultado = validador.validar("Senha@123");
        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }
}
