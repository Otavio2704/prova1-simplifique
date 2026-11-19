package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CpfUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"52998224725", "00000000604"})
    void deve_validar_cpf_valido(String cpf) {
        assertTrue(CpfUtil.valido(cpf));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"52998224735", "52998224724", "11111111111", "123", "5299822472X"})
    void nao_deve_validar_cpf_invalido(String cpf) {
        assertFalse(CpfUtil.valido(cpf));
    }
}
