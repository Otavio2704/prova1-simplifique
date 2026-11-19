package br.com.contmatic.prova.constants;

public final class AuditoriaConstants {
    public static final String CRIADOPOR_OBRIGATORIO = "Informe quem criou o registro.";
    public static final String ALTERADOPOR_OBRIGATORIO = "Informe quem alterou o registro.";
    public static final String DATAS_INVALIDAS =
            "Informe uma data de alteração igual ou posterior à criação.";
    public static final String TOSTRING_INICIO = "Auditoria{";
    public static final String TOSTRING_FIM = "}";
    public static final String TOSTRING_CRIADOPOR = "criadoPor=";
    public static final String TOSTRING_DATAHORACRIACAO = ", dataHoraCriacao=";
    public static final String TOSTRING_ALTERADOPOR = ", alteradoPor=";
    public static final String TOSTRING_DATAHORAALTERACAO = ", dataHoraAlteracao=";

    private AuditoriaConstants() {}
}
