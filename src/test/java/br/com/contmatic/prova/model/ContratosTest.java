package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContratosTest {
    private void verificarContrato(Object a, Object b, Object outroTipo) {
        assertTrue(a.equals(a));
        assertEquals(a, b);
        assertEquals(b, a);
        assertEquals(a.hashCode(), b.hashCode());
        assertFalse(a.equals(null));
        assertFalse(a.equals(outroTipo));
        assertNotNull(a.toString());
    }

    @Test
    void deve_respeitar_contrato_de_igualdade_de_empresa() {
        Empresa a = new Empresa();
        a.setCnpj("11222333000181");
        Empresa b = new Empresa();
        b.setCnpj("11222333000181");
        verificarContrato(a, b, new Endereco());
    }

    @Test
    void deve_respeitar_contrato_de_igualdade_de_endereco() {
        verificarContrato(new Endereco(), new Endereco(), new Telefone());
    }

    @Test
    void deve_respeitar_contrato_de_igualdade_de_telefone() {
        verificarContrato(new Telefone(), new Telefone(), new Auditoria());
    }

    @Test
    void deve_respeitar_contrato_de_igualdade_de_auditoria() {
        verificarContrato(new Auditoria(), new Auditoria(), new Empresa());
    }

    @Test
    void deve_exibir_razao_social_no_to_string_de_empresa() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Padaria");
        assertTrue(empresa.toString().contains("razaoSocial=Padaria"));
    }

    @Test
    void deve_exibir_cidade_no_to_string_de_endereco() {
        Endereco endereco = new Endereco();
        endereco.setCidade("Suzano");
        assertTrue(endereco.toString().contains("cidade=Suzano"));
    }

    @Test
    void deve_exibir_ddd_no_to_string_de_telefone() {
        Telefone telefone = new Telefone();
        telefone.setDdd("11");
        assertTrue(telefone.toString().contains("ddd=11"));
    }

    @Test
    void deve_exibir_criador_no_to_string_de_auditoria() {
        Auditoria auditoria = new Auditoria();
        auditoria.setCriadoPor("Ana");
        assertTrue(auditoria.toString().contains("criadoPor=Ana"));
    }

    @Test
    void nao_deve_igualar_empresas_com_cnpj_diferente() {
        Empresa a = new Empresa();
        a.setCnpj("11222333000181");
        a.setRazaoSocial("Uma");
        Empresa b = new Empresa();
        b.setCnpj("12ABC34501DE35");
        b.setRazaoSocial("Uma");
        assertNotEquals(a, b);
    }

    @Test
    void nao_deve_igualar_enderecos_com_cidade_diferente() {
        Endereco a = new Endereco();
        a.setCidade("Suzano");
        assertNotEquals(a, new Endereco());
    }

    @Test
    void nao_deve_igualar_telefones_com_ddd_diferente() {
        Telefone a = new Telefone();
        a.setDdd("11");
        assertNotEquals(a, new Telefone());
    }

    @Test
    void nao_deve_igualar_auditorias_com_criador_diferente() {
        Auditoria a = new Auditoria();
        a.setCriadoPor("Ana");
        assertNotEquals(a, new Auditoria());
    }
}
