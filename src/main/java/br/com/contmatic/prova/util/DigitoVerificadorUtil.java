package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constants.DocumentoConstants;

/** Cálculo compartilhado dos dígitos verificadores de CPF e CNPJ. */
final class DigitoVerificadorUtil {
    private DigitoVerificadorUtil() {}

    static int calcular(String valor, int[] pesos) {
        int soma = DocumentoConstants.INDICE_INICIAL;
        for (int i = DocumentoConstants.INDICE_INICIAL; i < pesos.length; i++) {
            soma += (valor.charAt(i) - DocumentoConstants.CARACTERE_ZERO) * pesos[i];
        }
        int resto = soma % DocumentoConstants.MODULO;
        return resto < DocumentoConstants.LIMITE_RESTO
                ? DocumentoConstants.DIGITO_ZERO
                : DocumentoConstants.MODULO - resto;
    }
}
