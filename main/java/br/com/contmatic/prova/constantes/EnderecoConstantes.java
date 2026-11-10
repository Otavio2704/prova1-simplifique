package br.com.contmatic.prova.constantes;

public final class EnderecoConstantes {
    public static final String LOGRADOURO_OBRIGATORIO = "Informe o logradouro.";
    public static final String NUMERO_OBRIGATORIO = "Informe o número.";
    public static final String CIDADE_OBRIGATORIO = "Informe a cidade.";
    public static final String ESTADO_OBRIGATORIO = "Informe o estado.";
    public static final String CEP_OBRIGATORIO = "Informe o CEP.";
    public static final String TOSTRING_INICIO = "Endereco{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_LOGRADOURO = "logradouro=";
    public static final String TOSTRING_NUMERO = ", numero=";
    public static final String TOSTRING_CIDADE = ", cidade=";
    public static final String TOSTRING_ESTADO = ", estado=";
    public static final String TOSTRING_CEP = ", cep=";
    public static final String TOSTRING_AUDITORIA = ", auditoria=";
    private EnderecoConstantes() { }

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
