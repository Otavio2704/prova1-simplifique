package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnderecoTest {
    @Test
    void deve_guardar_logradouro_informado() {
        Endereco objeto = new Endereco();
        objeto.setLogradouro("exemplo");
        assertEquals("exemplo", objeto.getLogradouro());
    }

    @Test
    void deve_guardar_numero_informado() {
        Endereco objeto = new Endereco();
        objeto.setNumero("exemplo");
        assertEquals("exemplo", objeto.getNumero());
    }

    @Test
    void deve_guardar_cidade_informado() {
        Endereco objeto = new Endereco();
        objeto.setCidade("exemplo");
        assertEquals("exemplo", objeto.getCidade());
    }

    @Test
    void deve_guardar_estado_informado() {
        Endereco objeto = new Endereco();
        objeto.setEstado("SP");
        assertEquals("SP", objeto.getEstado());
    }

    @Test
    void deve_guardar_cep_informado() {
        Endereco objeto = new Endereco();
        objeto.setCep("08600000");
        assertEquals("08600000", objeto.getCep());
    }

    @Test
    void deve_guardar_auditoria_informada() {
        Endereco objeto = new Endereco();
        Auditoria auditoria = new Auditoria();
        objeto.setAuditoria(auditoria);
        assertSame(auditoria, objeto.getAuditoria());
    }
}
