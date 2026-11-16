package br.com.contmatic.prova.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class EnderecoTest {
    @Test void deve_guardar_os_dados_informados() {
        Endereco objeto = new Endereco();
        objeto.setLogradouro("exemplo");
        assertEquals("exemplo", objeto.getLogradouro());
        objeto.setNumero("exemplo");
        assertEquals("exemplo", objeto.getNumero());
        objeto.setCidade("exemplo");
        assertEquals("exemplo", objeto.getCidade());
        objeto.setEstado("exemplo");
        assertEquals("exemplo", objeto.getEstado());
        objeto.setCep("exemplo");
        assertEquals("exemplo", objeto.getCep());
    }
    @Test void deve_guardar_a_auditoria_informada() {
        Endereco objeto = new Endereco();
        Auditoria auditoria = new Auditoria();
        objeto.setAuditoria(auditoria);
        assertEquals(auditoria, objeto.getAuditoria());
    }
    @Test void nao_deve_aceitar_texto_em_branco() {
        Endereco objeto = new Endereco();
        assertThrows(IllegalArgumentException.class, () -> objeto.setLogradouro(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setLogradouro(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setNumero(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setCidade(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setCidade(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setEstado(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setEstado(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setCep(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setCep(null));
    }
}
