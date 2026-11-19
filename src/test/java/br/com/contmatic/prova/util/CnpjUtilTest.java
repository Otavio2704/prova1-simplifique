package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CnpjUtilTest {
    @ParameterizedTest
    @ValueSource(
            strings = {
                "11222333000181",
                "11.222.333/0001-81",
                "12ABC34501DE35",
                "12.ABC.345/01DE-35",
                "12.abc.345/01de-35",
                "00000000000604"
            })
    void deve_validar_cnpj_valido(String cnpj) {
        assertTrue(CnpjUtil.valido(cnpj));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(
            strings = {
                "12ABC34501DE34",
                "12ABC34501DEA5",
                "12-ABC34501DE35",
                "11222333000191",
                "11222333000180",
                "11111111111111",
                "123",
                "1122233300018X",
                "11.22233300081",
                "11.222.333000181",
                " 11222333000181",
                "11222333000181 "
            })
    void nao_deve_validar_cnpj_invalido(String cnpj) {
        assertFalse(CnpjUtil.valido(cnpj));
    }

    @Test
    void deve_normalizar_cnpj_alfanumerico() {
        assertEquals("12ABC34501DE35", CnpjUtil.normalizar("12.abc.345/01de-35"));
    }

    @Test
    void nao_deve_normalizar_formato_invalido() {
        assertNull(CnpjUtil.normalizar("123"));
    }

    @Test
    void deve_normalizar_apenas_cnpj_valido() {
        assertEquals("12ABC34501DE35", CnpjUtil.normalizarSeValido("12.abc.345/01de-35"));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"123", "11111111111111", "11222333000180"})
    void nao_deve_normalizar_como_valido_um_cnpj_invalido(String cnpj) {
        assertNull(CnpjUtil.normalizarSeValido(cnpj));
    }
}
