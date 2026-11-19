package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/** Documenta a comparação literal atual, sem alterar as regras de igualdade. */
class IgualdadeFormatoTest {
    @Test
    void nao_deve_igualar_enderecos_com_mesmo_cep_e_mascaras_diferentes() {
        Endereco semHifen = new Endereco();
        semHifen.setCep("08600000");
        Endereco comHifen = new Endereco();
        comHifen.setCep("08600-000");
        assertEquals("08600000", semHifen.getCep());
        assertEquals("08600-000", comHifen.getCep());
        assertNotEquals(semHifen, comHifen);
        assertNotEquals(comHifen, semHifen);
    }

    @Test
    void nao_deve_igualar_telefones_com_mesmo_numero_e_mascaras_diferentes() {
        Telefone semHifen = new Telefone();
        semHifen.setDdd("11");
        semHifen.setNumero("912345678");
        Telefone comHifen = new Telefone();
        comHifen.setDdd("11");
        comHifen.setNumero("91234-5678");
        assertEquals("912345678", semHifen.getNumero());
        assertEquals("91234-5678", comHifen.getNumero());
        assertNotEquals(semHifen, comHifen);
        assertNotEquals(comHifen, semHifen);
    }
}
