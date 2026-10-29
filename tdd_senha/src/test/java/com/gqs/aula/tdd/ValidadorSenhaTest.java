package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    @Test
    void deveAceitarSenhaQueAtendeTodasAsRegras() {
        ResultadoValidacao resultado = validador.validar("Senha@123");
        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }

    @Test
    void deveRejeitarSenhaCom7Caracteres() {
        ResultadoValidacao resultado = validador.validar("Abc@123");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve ter pelo menos 8 caracteres"), resultado.getErros());
    }

    @Test
    void deveAceitarSenhaComExatamente8Caracteres() {
        assertTrue(validador.validar("Abcd@123").isValida());
    }

    @Test
    void deveRejeitarSenhaComApenas1Digito() {
        ResultadoValidacao resultado = validador.validar("Abcdef@1");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve conter pelo menos 2 dígitos"), resultado.getErros());
    }

    @Test
    void deveAceitarSenhaComExatamente2Digitos() {
        assertTrue(validador.validar("Abcde@12").isValida());
    }

    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        ResultadoValidacao resultado = validador.validar("abcde@12");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve conter pelo menos uma letra maiuscula"), resultado.getErros());
    }

    @Test
    void deveRejeitarSenhaSemCaractereEspecial() {
        ResultadoValidacao resultado = validador.validar("Abcdef12");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve conter pelo menos um caractere especial"), resultado.getErros());
    }

    @Test
    void deveRetornarTodosOsErrosParaMypass() {
        ResultadoValidacao resultado = validador.validar("mypass");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList(
            "A senha deve ter pelo menos 8 caracteres",
            "A senha deve conter pelo menos 2 dígitos",
            "A senha deve conter pelo menos uma letra maiuscula",
            "A senha deve conter pelo menos um caractere especial"), resultado.getErros());
    }

    @Test
    void deveRetornarDoisErrosQuandoFaltamDigitosECaractereEspecial() {
        ResultadoValidacao resultado = validador.validar("Abcdefgh");
        assertEquals(Arrays.asList(
            "A senha deve conter pelo menos 2 dígitos",
            "A senha deve conter pelo menos um caractere especial"), resultado.getErros());
    }
}
