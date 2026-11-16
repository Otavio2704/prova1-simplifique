package br.com.contmatic.prova.constantes;

public final class AuditoriaConstantes {
    public static final String CRIADOPOR_OBRIGATORIO = "Informe quem criou o registro.";
    public static final String ALTERADOPOR_OBRIGATORIO = "Informe quem alterou o registro.";
    public static final String TOSTRING_INICIO = "Auditoria{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_CRIADOPOR = "criadoPor=";
    public static final String TOSTRING_DATAHORACRIACAO = ", dataHoraCriacao=";
    public static final String TOSTRING_ALTERADOPOR = ", alteradoPor=";
    public static final String TOSTRING_DATAHORAALTERACAO = ", dataHoraAlteracao=";
    private AuditoriaConstantes() { }

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
