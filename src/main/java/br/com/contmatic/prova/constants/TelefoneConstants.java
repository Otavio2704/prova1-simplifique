package br.com.contmatic.prova.constants;

public final class TelefoneConstants {
    public static final String DDD_OBRIGATORIO = "Informe o DDD.";
    public static final String NUMERO_OBRIGATORIO = "Informe o número.";
    public static final String DDD_INVALIDO = "Informe o DDD com 2 dígitos.";
    public static final String NUMERO_INVALIDO =
            "Informe o telefone com 8 ou 9 dígitos, com ou sem hífen.";
    public static final String PADRAO_DDD = "[0-9]{2}";
    public static final String PADRAO_NUMERO = "[0-9]{4,5}-?[0-9]{4}";
    public static final String TOSTRING_INICIO = "Telefone{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_DDD = "ddd=";
    public static final String TOSTRING_NUMERO = ", numero=";
    public static final String TOSTRING_AUDITORIA = ", auditoria=";

    private TelefoneConstants() {}
}
