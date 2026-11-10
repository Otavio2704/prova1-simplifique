package br.com.contmatic.prova.model;

import java.util.Objects;
import br.com.contmatic.prova.constantes.AuditoriaConstantes;
import br.com.contmatic.prova.util.ValidacaoUtil;
import java.time.LocalDateTime;

public class Auditoria {
    private String criadoPor;
    private LocalDateTime dataHoraCriacao;
    private String alteradoPor;
    private LocalDateTime dataHoraAlteracao;

    public String getCriadoPor() {
        return criadoPor;
    }
    public void setCriadoPor(String criadoPor) {
        ValidacaoUtil.exigirTexto(criadoPor, AuditoriaConstantes.CRIADOPOR_OBRIGATORIO);
        this.criadoPor = criadoPor;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }
    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }
    public void setAlteradoPor(String alteradoPor) {
        ValidacaoUtil.exigirTexto(alteradoPor, AuditoriaConstantes.ALTERADOPOR_OBRIGATORIO);
        this.alteradoPor = alteradoPor;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }
    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Auditoria outro = (Auditoria) objeto;
        return Objects.equals(criadoPor, outro.criadoPor) &&
                Objects.equals(dataHoraCriacao, outro.dataHoraCriacao) &&
                Objects.equals(alteradoPor, outro.alteradoPor) &&
                Objects.equals(dataHoraAlteracao, outro.dataHoraAlteracao);
    }
    @Override
    public int hashCode() {
        return Objects.hash(criadoPor, dataHoraCriacao, alteradoPor, dataHoraAlteracao);
    }
    @Override
    public String toString() {
        return new StringBuilder(AuditoriaConstantes.TOSTRING_INICIO)
                .append(AuditoriaConstantes.TOSTRING_CRIADOPOR).append(criadoPor)
                .append(AuditoriaConstantes.TOSTRING_DATAHORACRIACAO).append(dataHoraCriacao)
                .append(AuditoriaConstantes.TOSTRING_ALTERADOPOR).append(alteradoPor)
                .append(AuditoriaConstantes.TOSTRING_DATAHORAALTERACAO).append(dataHoraAlteracao)
                .append(AuditoriaConstantes.TOSTRING_FIM).toString();
    }
}
