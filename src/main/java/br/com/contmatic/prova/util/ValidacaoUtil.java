package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.DocumentoConstantes;
import br.com.contmatic.prova.constantes.ValidacaoConstantes;
import java.math.BigDecimal;

public final class ValidacaoUtil {
    private ValidacaoUtil() { }
    public static void exigirTexto(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void exigirNaoNegativo(BigDecimal valor, String mensagem) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) < ValidacaoConstantes.VALOR_ZERO) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    @Override
    public boolean equals(Object objeto) {
        return super.equals(objeto);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append(DocumentoConstantes.ABRE_CHAVE)
                .append(DocumentoConstantes.FECHA_CHAVE)
                .toString();
    }
}
