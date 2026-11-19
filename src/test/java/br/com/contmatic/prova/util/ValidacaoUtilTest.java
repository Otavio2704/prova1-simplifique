package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class ValidacaoUtilTest {
    @Test
    void deve_aceitar_texto_preenchido() {
        assertDoesNotThrow(() -> ValidacaoUtil.exigirTexto("texto", "mensagem"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t"})
    void nao_deve_aceitar_texto_vazio(String valor) {
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> ValidacaoUtil.exigirTexto(valor, "mensagem"));
        assertEquals("mensagem", erro.getMessage());
    }

    @Test
    void deve_aceitar_numero_nulo() {
        assertDoesNotThrow(() -> ValidacaoUtil.exigirNaoNegativo(null, "mensagem"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0.01", "10"})
    void deve_aceitar_numero_nao_negativo(String valor) {
        assertDoesNotThrow(
                () -> ValidacaoUtil.exigirNaoNegativo(new BigDecimal(valor), "mensagem"));
    }

    @Test
    void nao_deve_aceitar_numero_negativo() {
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> ValidacaoUtil.exigirNaoNegativo(new BigDecimal("-0.01"), "mensagem"));
        assertEquals("mensagem", erro.getMessage());
    }

    @Test
    void deve_verificar_formato_de_texto() {
        assertDoesNotThrow(() -> ValidacaoUtil.exigirFormato("11", "[0-9]{2}", "formato"));
    }

    @Test
    void nao_deve_aceitar_formato_invalido() {
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> ValidacaoUtil.exigirFormato("1a", "[0-9]{2}", "formato"));
        assertEquals("formato", erro.getMessage());
    }

    @Test
    void deve_aceitar_data_igual_ao_limite_informado() {
        LocalDate hoje = LocalDate.of(2024, 1, 1);
        assertDoesNotThrow(() -> ValidacaoUtil.exigirDataNaoFutura(hoje, hoje, "data"));
    }

    @Test
    void nao_deve_aceitar_data_apos_limite_informado() {
        LocalDate hoje = LocalDate.of(2024, 1, 1);
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> ValidacaoUtil.exigirDataNaoFutura(hoje.plusDays(1), hoje, "data"));
        assertEquals("data", erro.getMessage());
    }

    @Test
    void deve_aceitar_datas_em_ordem() {
        LocalDateTime criacao = LocalDateTime.of(2024, 1, 1, 0, 0);
        assertDoesNotThrow(
                () -> ValidacaoUtil.exigirDatasOrdenadas(criacao, criacao.plusSeconds(1), "datas"));
    }

    @Test
    void nao_deve_aceitar_datas_fora_de_ordem() {
        LocalDateTime criacao = LocalDateTime.of(2024, 1, 1, 0, 0);
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () ->
                                ValidacaoUtil.exigirDatasOrdenadas(
                                        criacao, criacao.minusSeconds(1), "datas"));
        assertEquals("datas", erro.getMessage());
    }

    @Test
    void deve_aceitar_lista_sem_nulos() {
        assertDoesNotThrow(() -> ValidacaoUtil.exigirElementosNaoNulos(List.of("valor"), "lista"));
    }

    @Test
    void nao_deve_aceitar_lista_com_nulo() {
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () ->
                                ValidacaoUtil.exigirElementosNaoNulos(
                                        Arrays.asList("valor", null), "lista"));
        assertEquals("lista", erro.getMessage());
    }
}
