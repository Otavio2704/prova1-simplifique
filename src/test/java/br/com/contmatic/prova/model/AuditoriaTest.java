package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AuditoriaTest {
    @Test
    void deve_guardar_criadopor_informado() {
        Auditoria objeto = new Auditoria();
        objeto.setCriadoPor("exemplo");
        assertEquals("exemplo", objeto.getCriadoPor());
    }

    @Test
    void deve_guardar_alteradopor_informado() {
        Auditoria objeto = new Auditoria();
        objeto.setAlteradoPor("exemplo");
        assertEquals("exemplo", objeto.getAlteradoPor());
    }

    @Test
    void deve_guardar_datahoracriacao_informada() {
        Auditoria objeto = new Auditoria();
        LocalDateTime data = LocalDateTime.of(2024, 1, 1, 10, 30);
        objeto.setDataHoraCriacao(data);
        assertEquals(data, objeto.getDataHoraCriacao());
    }

    @Test
    void deve_guardar_datahoraalteracao_informada() {
        Auditoria objeto = new Auditoria();
        LocalDateTime data = LocalDateTime.of(2024, 1, 1, 10, 30);
        objeto.setDataHoraAlteracao(data);
        assertEquals(data, objeto.getDataHoraAlteracao());
    }
}
