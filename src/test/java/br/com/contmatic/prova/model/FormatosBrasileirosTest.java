package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class FormatosBrasileirosTest {
    @ParameterizedTest
    @ValueSource(
            strings = {
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
                "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "sp"
            })
    void deve_aceitar_uf_brasileira_e_guardar_maiuscula(String uf) {
        Endereco endereco = new Endereco();
        endereco.setEstado(uf);
        assertEquals(uf.toUpperCase(java.util.Locale.ROOT), endereco.getEstado());
    }

    @ParameterizedTest
    @ValueSource(strings = {"XX", "S", "SPP", "S1", " SP"})
    void nao_deve_aceitar_uf_invalida_e_deve_preservar_anterior(String uf) {
        Endereco e = new Endereco();
        e.setEstado("SP");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> e.setEstado(uf));
        assertEquals("Informe uma sigla de estado brasileira válida.", erro.getMessage());
        assertEquals("SP", e.getEstado());
    }

    @ParameterizedTest
    @ValueSource(strings = {"08600000", "08600-000"})
    void deve_aceitar_cep_com_ou_sem_hifen(String cep) {
        Endereco e = new Endereco();
        e.setCep(cep);
        assertEquals(cep, e.getCep());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "123456789", "1234-5678", "12345-67A", " 08600000"})
    void nao_deve_aceitar_cep_invalido_e_deve_preservar_anterior(String cep) {
        Endereco e = new Endereco();
        e.setCep("08600000");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> e.setCep(cep));
        assertEquals("Informe o CEP com 8 dígitos, com ou sem hífen.", erro.getMessage());
        assertEquals("08600000", e.getCep());
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "00", "99"})
    void deve_aceitar_ddd_com_dois_digitos(String ddd) {
        Telefone t = new Telefone();
        t.setDdd(ddd);
        assertEquals(ddd, t.getDdd());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "111", "a1", "(11)", " 11"})
    void nao_deve_aceitar_ddd_invalido_e_deve_preservar_anterior(String ddd) {
        Telefone t = new Telefone();
        t.setDdd("11");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> t.setDdd(ddd));
        assertEquals("Informe o DDD com 2 dígitos.", erro.getMessage());
        assertEquals("11", t.getDdd());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "1234-5678", "912345678", "91234-5678"})
    void deve_aceitar_telefone_com_oito_ou_nove_digitos(String numero) {
        Telefone t = new Telefone();
        t.setNumero(numero);
        assertEquals(numero, t.getNumero());
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                "1234567",
                "1234567890",
                "123-45678",
                "12345-67890",
                "1234-567A",
                " 12345678"
            })
    void nao_deve_aceitar_telefone_invalido_e_deve_preservar_anterior(String numero) {
        Telefone t = new Telefone();
        t.setNumero("12345678");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> t.setNumero(numero));
        assertEquals("Informe o telefone com 8 ou 9 dígitos, com ou sem hífen.", erro.getMessage());
        assertEquals("12345678", t.getNumero());
    }

    @Test
    void nao_deve_aceitar_elementos_nulos_e_deve_preservar_lista() {
        Empresa empresa = new Empresa();
        Telefone telefone = new Telefone();
        empresa.setTelefones(List.of(telefone));
        List<Telefone> lista = new ArrayList<>();
        lista.add(telefone);
        lista.add(null);
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> empresa.setTelefones(lista));
        assertEquals("Informe telefones sem elementos nulos.", erro.getMessage());
        assertEquals(List.of(telefone), empresa.getTelefones());
    }
}
