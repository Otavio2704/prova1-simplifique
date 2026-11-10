package br.com.contmatic.prova.model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
class AuditoriaTest {
    @Test void deve_guardar_os_dados_informados() {
        Auditoria objeto = new Auditoria();
        objeto.setCriadoPor("exemplo");
        assertEquals("exemplo", objeto.getCriadoPor());
        objeto.setDataHoraCriacao(LocalDateTime.of(2024, 1, 1, 10, 30));
        assertEquals(LocalDateTime.of(2024, 1, 1, 10, 30), objeto.getDataHoraCriacao());
        objeto.setAlteradoPor("exemplo");
        assertEquals("exemplo", objeto.getAlteradoPor());
        objeto.setDataHoraAlteracao(LocalDateTime.of(2024, 1, 1, 10, 30));
        assertEquals(LocalDateTime.of(2024, 1, 1, 10, 30), objeto.getDataHoraAlteracao());
    }
    @Test void nao_deve_aceitar_texto_em_branco() {
        Auditoria objeto = new Auditoria();
        assertThrows(IllegalArgumentException.class, () -> objeto.setCriadoPor(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setCriadoPor(null));
        assertThrows(IllegalArgumentException.class, () -> objeto.setAlteradoPor(" "));
        assertThrows(IllegalArgumentException.class, () -> objeto.setAlteradoPor(null));
    }
}
