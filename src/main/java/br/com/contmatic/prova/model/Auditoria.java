package br.com.contmatic.prova.model;

import br.com.contmatic.prova.constants.AuditoriaConstants;
import br.com.contmatic.prova.util.ValidacaoUtil;

import java.time.LocalDateTime;
import java.util.Objects;

public class Auditoria {
    private String criadoPor;
    private LocalDateTime dataHoraCriacao;
    private String alteradoPor;
    private LocalDateTime dataHoraAlteracao;

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        ValidacaoUtil.exigirTexto(criadoPor, AuditoriaConstants.CRIADOPOR_OBRIGATORIO);
        this.criadoPor = criadoPor;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        ValidacaoUtil.exigirDatasOrdenadas(
                dataHoraCriacao, dataHoraAlteracao, AuditoriaConstants.DATAS_INVALIDAS);
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        ValidacaoUtil.exigirTexto(alteradoPor, AuditoriaConstants.ALTERADOPOR_OBRIGATORIO);
        this.alteradoPor = alteradoPor;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        ValidacaoUtil.exigirDatasOrdenadas(
                dataHoraCriacao, dataHoraAlteracao, AuditoriaConstants.DATAS_INVALIDAS);
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Auditoria outro = (Auditoria) objeto;
        return Objects.equals(criadoPor, outro.criadoPor)
                && Objects.equals(dataHoraCriacao, outro.dataHoraCriacao)
                && Objects.equals(alteradoPor, outro.alteradoPor)
                && Objects.equals(dataHoraAlteracao, outro.dataHoraAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criadoPor, dataHoraCriacao, alteradoPor, dataHoraAlteracao);
    }

    @Override
    public String toString() {
        return new StringBuilder(AuditoriaConstants.TOSTRING_INICIO)
                .append(AuditoriaConstants.TOSTRING_CRIADOPOR)
                .append(criadoPor)
                .append(AuditoriaConstants.TOSTRING_DATAHORACRIACAO)
                .append(dataHoraCriacao)
                .append(AuditoriaConstants.TOSTRING_ALTERADOPOR)
                .append(alteradoPor)
                .append(AuditoriaConstants.TOSTRING_DATAHORAALTERACAO)
                .append(dataHoraAlteracao)
                .append(AuditoriaConstants.TOSTRING_FIM)
                .toString();
    }
}
