package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constants.DocumentoConstants;

public final class CpfUtil {
    private CpfUtil() {}

    public static boolean valido(String valor) {
        return temFormatoValido(valor) && temDigitosValidos(valor);
    }

    private static boolean temFormatoValido(String valor) {
        return valor != null
                && valor.length() == DocumentoConstants.CPF_TAMANHO
                && valor.matches(DocumentoConstants.PADRAO_DIGITOS)
                && !valor.matches(DocumentoConstants.PADRAO_DIGITOS_IGUAIS);
    }

    private static boolean temDigitosValidos(String valor) {
        int primeiro = DigitoVerificadorUtil.calcular(valor, DocumentoConstants.cpfPesosPrimeiro());
        int segundo = DigitoVerificadorUtil.calcular(valor, DocumentoConstants.cpfPesosSegundo());
        int primeiroInformado =
                valor.charAt(
                                DocumentoConstants.CPF_TAMANHO
                                        - DocumentoConstants.DESLOCAMENTO_PRIMEIRO_DIGITO)
                        - DocumentoConstants.CARACTERE_ZERO;
        int segundoInformado =
                valor.charAt(
                                DocumentoConstants.CPF_TAMANHO
                                        - DocumentoConstants.DESLOCAMENTO_SEGUNDO_DIGITO)
                        - DocumentoConstants.CARACTERE_ZERO;
        return primeiro == primeiroInformado && segundo == segundoInformado;
    }
}
