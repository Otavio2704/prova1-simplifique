package br.com.contmatic.prova.model;

import br.com.contmatic.prova.constants.TelefoneConstants;
import br.com.contmatic.prova.util.ValidacaoUtil;

import java.util.Objects;

public class Telefone {
    private String ddd;
    private String numero;
    private Auditoria auditoria;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        ValidacaoUtil.exigirTexto(ddd, TelefoneConstants.DDD_OBRIGATORIO);
        ValidacaoUtil.exigirFormato(
                ddd, TelefoneConstants.PADRAO_DDD, TelefoneConstants.DDD_INVALIDO);
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        ValidacaoUtil.exigirTexto(numero, TelefoneConstants.NUMERO_OBRIGATORIO);
        ValidacaoUtil.exigirFormato(
                numero, TelefoneConstants.PADRAO_NUMERO, TelefoneConstants.NUMERO_INVALIDO);
        this.numero = numero;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Telefone outro = (Telefone) objeto;
        return Objects.equals(ddd, outro.ddd) && Objects.equals(numero, outro.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public String toString() {
        return new StringBuilder(TelefoneConstants.TOSTRING_INICIO)
                .append(TelefoneConstants.TOSTRING_DDD)
                .append(ddd)
                .append(TelefoneConstants.TOSTRING_NUMERO)
                .append(numero)
                .append(TelefoneConstants.TOSTRING_AUDITORIA)
                .append(auditoria)
                .append(TelefoneConstants.TOSTRING_FIM)
                .toString();
    }
}
