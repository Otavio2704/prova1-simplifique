package br.com.contmatic.prova.constantes;

public final class TelefoneConstantes {
    public static final String DDD_OBRIGATORIO = "Informe o DDD.";
    public static final String NUMERO_OBRIGATORIO = "Informe o número.";
    public static final String TOSTRING_INICIO = "Telefone{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_DDD = "ddd=";
    public static final String TOSTRING_NUMERO = ", numero=";
    public static final String TOSTRING_AUDITORIA = ", auditoria=";
    private TelefoneConstantes() { }

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
