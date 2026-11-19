package br.com.contmatic.prova.constants;

public final class DocumentoConstants {
    public static final String PADRAO_CNPJ =
            "(?:[A-Za-z0-9]{12}[0-9]{2}|"
                    + "[A-Za-z0-9]{2}\\.[A-Za-z0-9]{3}\\.[A-Za-z0-9]{3}/[A-Za-z0-9]{4}-[0-9]{2})";
    public static final String PONTO = ".";
    public static final String BARRA = "/";
    public static final String HIFEN = "-";
    public static final String VAZIO = "";
    public static final String PADRAO_DIGITOS = "[0-9]+";
    public static final String PADRAO_DIGITOS_IGUAIS = "(\\d)\\1+";
    public static final int CPF_TAMANHO = 11;
    public static final int CNPJ_TAMANHO = 14;
    public static final int MODULO = 11;
    public static final int LIMITE_RESTO = 2;
    public static final int INDICE_INICIAL = 0;
    public static final int DIGITO_ZERO = 0;
    public static final int DESLOCAMENTO_PRIMEIRO_DIGITO = 2;
    public static final int DESLOCAMENTO_SEGUNDO_DIGITO = 1;
    public static final char CARACTERE_ZERO = '0';
    private static final int[] CPF_PESOS_PRIMEIRO = {10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CPF_PESOS_SEGUNDO = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CNPJ_PESOS_PRIMEIRO = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CNPJ_PESOS_SEGUNDO = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static int[] cpfPesosPrimeiro() {
        return CPF_PESOS_PRIMEIRO.clone();
    }

    public static int[] cpfPesosSegundo() {
        return CPF_PESOS_SEGUNDO.clone();
    }

    public static int[] cnpjPesosPrimeiro() {
        return CNPJ_PESOS_PRIMEIRO.clone();
    }

    public static int[] cnpjPesosSegundo() {
        return CNPJ_PESOS_SEGUNDO.clone();
    }

    private DocumentoConstants() {}
}
