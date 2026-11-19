package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

class RegrasDatasTest {
    private static final LocalDateTime CRIACAO = LocalDateTime.of(2024, 1, 2, 10, 0);
    private static final LocalDateTime ANTES = CRIACAO.minusSeconds(1);
    private static final LocalDateTime DEPOIS = CRIACAO.plusSeconds(1);

    @Test
    void nao_deve_aceitar_fundacao_futura_e_deve_preservar_valor() {
        Empresa empresa = new Empresa();
        LocalDate anterior = LocalDate.of(2020, 1, 1);
        empresa.setDataFundacao(anterior);
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> empresa.setDataFundacao(LocalDate.now().plusDays(2)));
        assertEquals("Informe uma data de fundação que não seja futura.", erro.getMessage());
        assertEquals(anterior, empresa.getDataFundacao());
    }

    @Test
    void deve_aceitar_fundacao_hoje() {
        Empresa empresa = new Empresa();
        LocalDate hoje = LocalDate.now();
        empresa.setDataFundacao(hoje);
        assertEquals(hoje, empresa.getDataFundacao());
    }

    @Test
    void deve_aceitar_fundacao_nula() {
        Empresa empresa = new Empresa();
        empresa.setDataFundacao(null);
        assertNull(empresa.getDataFundacao());
    }

    @Test
    void nao_deve_aceitar_alteracao_anterior_e_deve_preservar_valor() {
        Auditoria a = new Auditoria();
        a.setDataHoraCriacao(CRIACAO);
        a.setDataHoraAlteracao(DEPOIS);
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> a.setDataHoraAlteracao(ANTES));
        assertEquals(
                "Informe uma data de alteração igual ou posterior à criação.", erro.getMessage());
        assertEquals(DEPOIS, a.getDataHoraAlteracao());
    }

    @Test
    void nao_deve_aceitar_criacao_posterior_a_alteracao_e_deve_preservar_valor() {
        Auditoria a = new Auditoria();
        a.setDataHoraAlteracao(CRIACAO);
        a.setDataHoraCriacao(ANTES);
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> a.setDataHoraCriacao(DEPOIS));
        assertEquals(
                "Informe uma data de alteração igual ou posterior à criação.", erro.getMessage());
        assertEquals(ANTES, a.getDataHoraCriacao());
    }

    @Test
    void deve_aceitar_datas_iguais_em_qualquer_ordem() {
        Auditoria primeira = new Auditoria();
        primeira.setDataHoraCriacao(CRIACAO);
        primeira.setDataHoraAlteracao(CRIACAO);
        Auditoria segunda = new Auditoria();
        segunda.setDataHoraAlteracao(CRIACAO);
        segunda.setDataHoraCriacao(CRIACAO);
        assertEquals(CRIACAO, primeira.getDataHoraAlteracao());
        assertEquals(CRIACAO, segunda.getDataHoraCriacao());
    }

    @Test
    void deve_aceitar_datas_nulas() {
        Auditoria a = new Auditoria();
        a.setDataHoraCriacao(CRIACAO);
        a.setDataHoraAlteracao(DEPOIS);
        a.setDataHoraCriacao(null);
        a.setDataHoraAlteracao(null);
        assertNull(a.getDataHoraCriacao());
        assertNull(a.getDataHoraAlteracao());
    }
}
