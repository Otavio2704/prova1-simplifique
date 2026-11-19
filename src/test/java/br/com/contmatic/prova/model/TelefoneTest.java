package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TelefoneTest {
    @Test
    void deve_guardar_ddd_informado() {
        Telefone objeto = new Telefone();
        objeto.setDdd("11");
        assertEquals("11", objeto.getDdd());
    }

    @Test
    void deve_guardar_numero_informado() {
        Telefone objeto = new Telefone();
        objeto.setNumero("12345678");
        assertEquals("12345678", objeto.getNumero());
    }

    @Test
    void deve_guardar_auditoria_informada() {
        Telefone objeto = new Telefone();
        Auditoria auditoria = new Auditoria();
        objeto.setAuditoria(auditoria);
        assertSame(auditoria, objeto.getAuditoria());
    }
}
