package br.com.contmatic.prova.model;

import java.util.Objects;
import br.com.contmatic.prova.constantes.TelefoneConstantes;
import br.com.contmatic.prova.util.ValidacaoUtil;

public class Telefone {
    private String ddd;
    private String numero;
    private Auditoria auditoria;

    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        ValidacaoUtil.exigirTexto(ddd, TelefoneConstantes.DDD_OBRIGATORIO);
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        ValidacaoUtil.exigirTexto(numero, TelefoneConstantes.NUMERO_OBRIGATORIO);
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
        return Objects.equals(ddd, outro.ddd) &&
                Objects.equals(numero, outro.numero) &&
                Objects.equals(auditoria, outro.auditoria);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero, auditoria);
    }
    @Override
    public String toString() {
        return new StringBuilder(TelefoneConstantes.TOSTRING_INICIO)
                .append(TelefoneConstantes.TOSTRING_DDD).append(ddd)
                .append(TelefoneConstantes.TOSTRING_NUMERO).append(numero)
                .append(TelefoneConstantes.TOSTRING_AUDITORIA).append(auditoria)
                .append(TelefoneConstantes.TOSTRING_FIM).toString();
    }
}
