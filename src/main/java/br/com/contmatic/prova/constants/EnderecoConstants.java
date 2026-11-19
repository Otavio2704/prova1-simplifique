package br.com.contmatic.prova.constants;

public final class EnderecoConstants {
    public static final String LOGRADOURO_OBRIGATORIO = "Informe o logradouro.";
    public static final String NUMERO_OBRIGATORIO = "Informe o número.";
    public static final String CIDADE_OBRIGATORIO = "Informe a cidade.";
    public static final String ESTADO_OBRIGATORIO = "Informe o estado.";
    public static final String CEP_OBRIGATORIO = "Informe o CEP.";
    public static final String ESTADO_INVALIDO = "Informe uma sigla de estado brasileira válida.";
    public static final String CEP_INVALIDO = "Informe o CEP com 8 dígitos, com ou sem hífen.";
    public static final String PADRAO_UF =
            "(?:AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)";
    public static final String PADRAO_CEP = "[0-9]{5}-?[0-9]{3}";
    public static final String TOSTRING_INICIO = "Endereco{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_LOGRADOURO = "logradouro=";
    public static final String TOSTRING_NUMERO = ", numero=";
    public static final String TOSTRING_CIDADE = ", cidade=";
    public static final String TOSTRING_ESTADO = ", estado=";
    public static final String TOSTRING_CEP = ", cep=";
    public static final String TOSTRING_AUDITORIA = ", auditoria=";

    private EnderecoConstants() {}
}
