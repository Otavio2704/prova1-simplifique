package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.DocumentoConstantes;
import java.util.Locale;

public final class CnpjUtil {
    private CnpjUtil() { }
    /** Retorna o CNPJ sem pontuação, em maiúsculas; null indica formato inválido. */
    public static String normalizar(String valor) {
        if (valor == null || !valor.matches(DocumentoConstantes.PADRAO_CNPJ)) {
            return null;
        }
        return valor.replace(DocumentoConstantes.PONTO, DocumentoConstantes.VAZIO)
                .replace(DocumentoConstantes.BARRA, DocumentoConstantes.VAZIO)
                .replace(DocumentoConstantes.HIFEN, DocumentoConstantes.VAZIO)
                .toUpperCase(Locale.ROOT);
    }
    public static boolean valido(String valor) {
        String cnpj = normalizar(valor);
        if (cnpj == null || cnpj.matches(DocumentoConstantes.PADRAO_DIGITOS_IGUAIS)) {
            return false;
        }
        int primeiro = calcular(cnpj, DocumentoConstantes.cnpjPesosPrimeiro());
        int segundo = calcular(cnpj, DocumentoConstantes.cnpjPesosSegundo());
        int primeiroInformado = cnpj.charAt(DocumentoConstantes.CNPJ_TAMANHO
                - DocumentoConstantes.DESLOCAMENTO_PRIMEIRO_DIGITO) - DocumentoConstantes.CARACTERE_ZERO;
        int segundoInformado = cnpj.charAt(DocumentoConstantes.CNPJ_TAMANHO
                - DocumentoConstantes.DESLOCAMENTO_SEGUNDO_DIGITO) - DocumentoConstantes.CARACTERE_ZERO;
        return primeiro == primeiroInformado && segundo == segundoInformado;
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
