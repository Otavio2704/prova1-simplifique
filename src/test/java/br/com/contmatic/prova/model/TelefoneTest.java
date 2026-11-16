package br.com.contmatic.prova.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TelefoneTest {
    @Test void deve_guardar_os_dados_informados() {
        Telefone objeto = new Telefone();
        objeto.setDdd("exemplo");
        assertEquals("exemplo", objeto.getDdd());
        objeto.setNumero("exemplo");
        assertEquals("exemplo", objeto.getNumero());
    }
    @Test void deve_guardar_a_auditoria_informada() {
        Telefone objeto = new Telefone();
        Auditoria auditoria = new Auditoria();
        objeto.setAuditoria(auditoria);
        assertEquals(auditoria, objeto.getAuditoria());
    }
    @Test void nao_deve_aceitar_texto_em_branco() {
        Telefone objeto = new Telefone();
        assertThrows(IllegalArgumentException.class, () -> objeto.setDdd(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setDdd(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(null));
    }
}
