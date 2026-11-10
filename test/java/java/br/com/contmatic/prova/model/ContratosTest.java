package br.com.contmatic.prova.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ContratosTest {
    @Test void deve_respeitar_contratos_de_igualdade() {
        Empresa primeira = new Empresa(); primeira.setCnpj("11222333000181");
        Empresa segunda = new Empresa(); segunda.setCnpj("11222333000181");
        verificar(primeira, segunda, new Endereco());
        verificar(new Endereco(), new Endereco(), new Telefone());
        verificar(new Telefone(), new Telefone(), new Auditoria());
        verificar(new Auditoria(), new Auditoria(), new Empresa());
    }
    private void verificar(Object a, Object b, Object outroTipo) {
        assertEquals(a, a); assertEquals(a, b); assertEquals(b, a);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, null); assertNotEquals(a, outroTipo);
        assertNotNull(a.toString());
    }
    @Test void deve_exibir_os_atributos_no_to_string() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Padaria");
        assertTrue(empresa.toString().contains("razaoSocial=Padaria"));
        Endereco endereco = new Endereco();
        endereco.setCidade("Suzano");
        assertTrue(endereco.toString().contains("cidade=Suzano"));
        Telefone telefone = new Telefone();
        telefone.setDdd("11");
        assertTrue(telefone.toString().contains("ddd=11"));
        Auditoria auditoria = new Auditoria();
        auditoria.setCriadoPor("Ana");
        assertTrue(auditoria.toString().contains("criadoPor=Ana"));
    }
    @Test void nao_deve_igualar_objetos_com_dados_diferentes() {
        Empresa e1 = new Empresa(); Empresa e2 = new Empresa(); e1.setRazaoSocial("Uma"); assertNotEquals(e1, e2);
        Endereco d1 = new Endereco(); Endereco d2 = new Endereco(); d1.setCidade("Suzano"); assertNotEquals(d1, d2);
        Telefone t1 = new Telefone(); Telefone t2 = new Telefone(); t1.setDdd("11"); assertNotEquals(t1, t2);
        Auditoria a1 = new Auditoria(); Auditoria a2 = new Auditoria(); a1.setCriadoPor("Ana"); assertNotEquals(a1, a2);
    }
}
