package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AuditoriaValidacaoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_criadopor_vazio_e_deve_preservar_valor(String valor) {
        Auditoria objeto = new Auditoria();
        objeto.setCriadoPor("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setCriadoPor(valor));
        assertEquals("Informe quem criou o registro.", erro.getMessage());
        assertEquals("valor anterior", objeto.getCriadoPor());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t"})
    void nao_deve_aceitar_alteradopor_vazio_e_deve_preservar_valor(String valor) {
        Auditoria objeto = new Auditoria();
        objeto.setAlteradoPor("valor anterior");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> objeto.setAlteradoPor(valor));
        assertEquals("Informe quem alterou o registro.", erro.getMessage());
        assertEquals("valor anterior", objeto.getAlteradoPor());
    }
}
