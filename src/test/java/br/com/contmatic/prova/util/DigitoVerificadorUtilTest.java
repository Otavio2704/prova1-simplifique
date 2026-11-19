package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DigitoVerificadorUtilTest {
    @Test
    void deve_retornar_zero_quando_resto_for_zero() {
        assertEquals(0, DigitoVerificadorUtil.calcular("0", new int[] {1}));
    }

    @Test
    void deve_retornar_zero_quando_resto_for_um() {
        assertEquals(0, DigitoVerificadorUtil.calcular("1", new int[] {1}));
    }

    @Test
    void deve_calcular_digito_quando_resto_for_dois() {
        assertEquals(9, DigitoVerificadorUtil.calcular("2", new int[] {1}));
    }

    @Test
    void deve_calcular_com_caractere_alfanumerico() {
        assertEquals(5, DigitoVerificadorUtil.calcular("A", new int[] {1}));
    }
}
