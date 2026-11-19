package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuditoriaIgualdadeTest {
    @Test
    void deve_ignorar_auditoria_na_igualdade_e_hash_de_endereco() {
        Endereco primeiro = new Endereco();
        Endereco segundo = new Endereco();
        Auditoria auditoria = new Auditoria();
        auditoria.setCriadoPor("Ana");
        primeiro.setAuditoria(auditoria);
        assertEquals(primeiro, segundo);
        assertEquals(primeiro.hashCode(), segundo.hashCode());
    }

    @Test
    void deve_ignorar_auditoria_na_igualdade_e_hash_de_telefone() {
        Telefone primeiro = new Telefone();
        Telefone segundo = new Telefone();
        Auditoria auditoria = new Auditoria();
        auditoria.setCriadoPor("Ana");
        primeiro.setAuditoria(auditoria);
        assertEquals(primeiro, segundo);
        assertEquals(primeiro.hashCode(), segundo.hashCode());
    }
}
