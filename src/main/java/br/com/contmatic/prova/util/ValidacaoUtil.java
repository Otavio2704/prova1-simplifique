package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constants.ValidacaoConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class ValidacaoUtil {
    private ValidacaoUtil() {}

    public static void exigirTexto(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirNaoNegativo(BigDecimal valor, String mensagem) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) < ValidacaoConstants.VALOR_ZERO) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirFormato(String valor, String padrao, String mensagem) {
        if (!valor.matches(padrao)) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirDataNaoFutura(LocalDate data, LocalDate hoje, String mensagem) {
        if (data != null && data.isAfter(hoje)) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirDatasOrdenadas(
            LocalDateTime criacao, LocalDateTime alteracao, String mensagem) {
        if (criacao != null && alteracao != null && alteracao.isBefore(criacao)) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirElementosNaoNulos(List<?> valores, String mensagem) {
        if (valores.stream().anyMatch(java.util.Objects::isNull)) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
