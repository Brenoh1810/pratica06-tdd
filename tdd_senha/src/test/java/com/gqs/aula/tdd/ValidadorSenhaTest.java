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

    @Test
    void deveRejeitarSenhaCom7Caracteres() {
        ValidadorSenha validador = new ValidadorSenha();
        ResultadoValidacao resultado = validador.validar("Abc@123");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve ter pelo menos 8 caracteres"), resultado.getErros());
    }

    @Test
    void deveAceitarSenhaComExatamente8Caracteres() {
        ValidadorSenha validador = new ValidadorSenha();
        assertTrue(validador.validar("Abcd@123").isValida());
    }
}
