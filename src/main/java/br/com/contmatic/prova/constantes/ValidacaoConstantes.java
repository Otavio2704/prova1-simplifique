package br.com.contmatic.prova.constantes;

public final class ValidacaoConstantes {
    public static final int VALOR_ZERO = 0;
    private ValidacaoConstantes() { }
    @Override
    public boolean equals(Object objeto) { return super.equals(objeto); }
    @Override
    public int hashCode() { return super.hashCode(); }
    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append(DocumentoConstantes.ABRE_CHAVE)
                .append(DocumentoConstantes.FECHA_CHAVE).toString();
    }
}
