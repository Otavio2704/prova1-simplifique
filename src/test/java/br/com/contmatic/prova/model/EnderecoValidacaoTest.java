package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EnderecoValidacaoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_logradouro_vazio_e_deve_preservar_valor(String valor) {
        Endereco objeto = new Endereco();
        objeto.setLogradouro("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setLogradouro(valor));
        assertEquals("Informe o logradouro.", erro.getMessage());
        assertEquals("valor anterior", objeto.getLogradouro());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_numero_vazio_e_deve_preservar_valor(String valor) {
        Endereco objeto = new Endereco();
        objeto.setNumero("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(valor));
        assertEquals("Informe o número.", erro.getMessage());
        assertEquals("valor anterior", objeto.getNumero());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_cidade_vazio_e_deve_preservar_valor(String valor) {
        Endereco objeto = new Endereco();
        objeto.setCidade("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setCidade(valor));
        assertEquals("Informe a cidade.", erro.getMessage());
        assertEquals("valor anterior", objeto.getCidade());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_estado_vazio_e_deve_preservar_valor(String valor) {
        Endereco objeto = new Endereco();
        objeto.setEstado("SP");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setEstado(valor));
        assertEquals("Informe o estado.", erro.getMessage());
        assertEquals("SP", objeto.getEstado());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_cep_vazio_e_deve_preservar_valor(String valor) {
        Endereco objeto = new Endereco();
        objeto.setCep("08600000");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setCep(valor));
        assertEquals("Informe o CEP.", erro.getMessage());
        assertEquals("08600000", objeto.getCep());
    }
}
