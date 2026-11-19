package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constants.DocumentoConstants;

import java.util.Locale;

public final class CnpjUtil {
    private CnpjUtil() {}

    /** Retorna o CNPJ sem pontuação, em maiúsculas; null indica formato inválido. */
    public static String normalizar(String valor) {
        if (valor == null || !valor.matches(DocumentoConstants.PADRAO_CNPJ)) {
            return null;
        }
        return valor.replace(DocumentoConstants.PONTO, DocumentoConstants.VAZIO)
                .replace(DocumentoConstants.BARRA, DocumentoConstants.VAZIO)
                .replace(DocumentoConstants.HIFEN, DocumentoConstants.VAZIO)
                .toUpperCase(Locale.ROOT);
    }

    public static boolean valido(String valor) {
        return normalizarSeValido(valor) != null;
    }

    /** Retorna o CNPJ normalizado apenas se formato e dígitos forem válidos. */
    public static String normalizarSeValido(String valor) {
        String cnpj = normalizar(valor);
        if (cnpj == null
                || cnpj.matches(DocumentoConstants.PADRAO_DIGITOS_IGUAIS)
                || !temDigitosValidos(cnpj)) {
            return null;
        }
        return cnpj;
    }

    private static boolean temDigitosValidos(String cnpj) {
        int primeiro = DigitoVerificadorUtil.calcular(cnpj, DocumentoConstants.cnpjPesosPrimeiro());
        int segundo = DigitoVerificadorUtil.calcular(cnpj, DocumentoConstants.cnpjPesosSegundo());
        int primeiroInformado =
                cnpj.charAt(
                                DocumentoConstants.CNPJ_TAMANHO
                                        - DocumentoConstants.DESLOCAMENTO_PRIMEIRO_DIGITO)
                        - DocumentoConstants.CARACTERE_ZERO;
        int segundoInformado =
                cnpj.charAt(
                                DocumentoConstants.CNPJ_TAMANHO
                                        - DocumentoConstants.DESLOCAMENTO_SEGUNDO_DIGITO)
                        - DocumentoConstants.CARACTERE_ZERO;
        return primeiro == primeiroInformado && segundo == segundoInformado;
    }
}
