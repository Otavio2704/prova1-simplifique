package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransitividadeIgualdadeTest {
    private void verificarTransitividade(Object a, Object b, Object c) {
        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(b.hashCode(), c.hashCode());
    }

    @Test
    void deve_respeitar_transitividade_de_empresa() {
        Empresa a = new Empresa();
        a.setCnpj("11.222.333/0001-81");
        Empresa b = new Empresa();
        b.setCnpj("11222333000181");
        Empresa c = new Empresa();
        c.setCnpj("11.222.333/0001-81");
        verificarTransitividade(a, b, c);
    }

    @Test
    void deve_respeitar_transitividade_de_endereco() {
        Endereco a = new Endereco();
        a.setCidade("Suzano");
        Endereco b = new Endereco();
        b.setCidade("Suzano");
        Endereco c = new Endereco();
        c.setCidade("Suzano");
        verificarTransitividade(a, b, c);
    }

    @Test
    void deve_respeitar_transitividade_de_telefone() {
        Telefone a = new Telefone();
        a.setDdd("11");
        Telefone b = new Telefone();
        b.setDdd("11");
        Telefone c = new Telefone();
        c.setDdd("11");
        verificarTransitividade(a, b, c);
    }

    @Test
    void deve_respeitar_transitividade_de_auditoria() {
        Auditoria a = new Auditoria();
        a.setCriadoPor("Ana");
        Auditoria b = new Auditoria();
        b.setCriadoPor("Ana");
        Auditoria c = new Auditoria();
        c.setCriadoPor("Ana");
        verificarTransitividade(a, b, c);
    }
}
