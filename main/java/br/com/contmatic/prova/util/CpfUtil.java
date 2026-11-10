package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.DocumentoConstantes;

public final class CpfUtil {
    private CpfUtil() { }
    public static boolean valido(String valor) {
        if (valor == null || valor.length() != DocumentoConstantes.CPF_TAMANHO || !valor.matches(DocumentoConstantes.PADRAO_DIGITOS)
                || valor.matches(DocumentoConstantes.PADRAO_DIGITOS_IGUAIS)) {
            return false;
        }
        int primeiro = calcular(valor, DocumentoConstantes.cpfPesosPrimeiro());
        int segundo = calcular(valor, DocumentoConstantes.cpfPesosSegundo());
        return primeiro == valor.charAt(DocumentoConstantes.CPF_TAMANHO - DocumentoConstantes.DESLOCAMENTO_PRIMEIRO_DIGITO) - DocumentoConstantes.CARACTERE_ZERO && segundo == valor.charAt(DocumentoConstantes.CPF_TAMANHO - DocumentoConstantes.DESLOCAMENTO_SEGUNDO_DIGITO) - DocumentoConstantes.CARACTERE_ZERO;
    }
    private static int calcular(String valor, int[] pesos) {
        int soma = DocumentoConstantes.INDICE_INICIAL;
        for (int i = DocumentoConstantes.INDICE_INICIAL; i < pesos.length; i++) {
            soma += (valor.charAt(i) - DocumentoConstantes.CARACTERE_ZERO) * pesos[i];
        }
        int resto = soma % DocumentoConstantes.MODULO;
        return resto < DocumentoConstantes.LIMITE_RESTO ? DocumentoConstantes.DIGITO_ZERO : DocumentoConstantes.MODULO - resto;
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
