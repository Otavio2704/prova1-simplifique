package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmpresaValidacaoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_razaosocial_vazio_e_deve_preservar_valor(String valor) {
        Empresa objeto = new Empresa();
        objeto.setRazaoSocial("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setRazaoSocial(valor));
        assertEquals("Informe a razão social.", erro.getMessage());
        assertEquals("valor anterior", objeto.getRazaoSocial());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_cnpj_vazio_e_deve_preservar_valor(String valor) {
        Empresa objeto = new Empresa();
        objeto.setCnpj("11222333000181");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setCnpj(valor));
        assertEquals("Informe o CNPJ.", erro.getMessage());
        assertEquals("11222333000181", objeto.getCnpj());
    }
}
