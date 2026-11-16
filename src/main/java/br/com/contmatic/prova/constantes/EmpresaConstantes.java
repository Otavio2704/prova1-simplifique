package br.com.contmatic.prova.constantes;

public final class EmpresaConstantes {
    public static final String CNPJ_OBRIGATORIO = "Informe o CNPJ.";
    public static final String RAZAOSOCIAL_OBRIGATORIO = "Informe a razão social.";
    public static final String CNPJ_INVALIDO = "Informe um CNPJ válido, com ou sem pontuação.";
    public static final String CAPITAL_INVALIDO = "Informe um capital social igual ou maior que zero.";
    public static final String TOSTRING_INICIO = "Empresa{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_CNPJ = "cnpj=";
    public static final String TOSTRING_RAZAOSOCIAL = ", razaoSocial=";
    public static final String TOSTRING_CAPITALSOCIAL = ", capitalSocial=";
    public static final String TOSTRING_DATAFUNDACAO = ", dataFundacao=";
    public static final String TOSTRING_ATIVA = ", ativa=";
    public static final String TOSTRING_TELEFONES = ", telefones=";
    public static final String TOSTRING_ENDERECO = ", endereco=";
    public static final String TOSTRING_AUDITORIA = ", auditoria=";
    public static final int COMPARACAO_ZERO = 0;
    private EmpresaConstantes() { }

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
