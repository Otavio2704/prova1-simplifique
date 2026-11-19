package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class TelefoneValidacaoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_ddd_vazio_e_deve_preservar_valor(String valor) {
        Telefone objeto = new Telefone();
        objeto.setDdd("11");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setDdd(valor));
        assertEquals("Informe o DDD.", erro.getMessage());
        assertEquals("11", objeto.getDdd());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_numero_vazio_e_deve_preservar_valor(String valor) {
        Telefone objeto = new Telefone();
        objeto.setNumero("12345678");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(valor));
        assertEquals("Informe o número.", erro.getMessage());
        assertEquals("12345678", objeto.getNumero());
    }
}
