package br.com.contmatic.prova.model;

import br.com.contmatic.prova.constants.EnderecoConstants;
import br.com.contmatic.prova.util.ValidacaoUtil;

import java.util.Locale;
import java.util.Objects;

public class Endereco {
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private Auditoria auditoria;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        ValidacaoUtil.exigirTexto(logradouro, EnderecoConstants.LOGRADOURO_OBRIGATORIO);
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        ValidacaoUtil.exigirTexto(numero, EnderecoConstants.NUMERO_OBRIGATORIO);
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        ValidacaoUtil.exigirTexto(cidade, EnderecoConstants.CIDADE_OBRIGATORIO);
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        ValidacaoUtil.exigirTexto(estado, EnderecoConstants.ESTADO_OBRIGATORIO);
        String uf = estado.toUpperCase(Locale.ROOT);
        ValidacaoUtil.exigirFormato(
                uf, EnderecoConstants.PADRAO_UF, EnderecoConstants.ESTADO_INVALIDO);
        this.estado = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        ValidacaoUtil.exigirTexto(cep, EnderecoConstants.CEP_OBRIGATORIO);
        ValidacaoUtil.exigirFormato(
                cep, EnderecoConstants.PADRAO_CEP, EnderecoConstants.CEP_INVALIDO);
        this.cep = cep;
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
        Endereco outro = (Endereco) objeto;
        return Objects.equals(logradouro, outro.logradouro)
                && Objects.equals(numero, outro.numero)
                && Objects.equals(cidade, outro.cidade)
                && Objects.equals(estado, outro.estado)
                && Objects.equals(cep, outro.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero, cidade, estado, cep);
    }

    @Override
    public String toString() {
        return new StringBuilder(EnderecoConstants.TOSTRING_INICIO)
                .append(EnderecoConstants.TOSTRING_LOGRADOURO)
                .append(logradouro)
                .append(EnderecoConstants.TOSTRING_NUMERO)
                .append(numero)
                .append(EnderecoConstants.TOSTRING_CIDADE)
                .append(cidade)
                .append(EnderecoConstants.TOSTRING_ESTADO)
                .append(estado)
                .append(EnderecoConstants.TOSTRING_CEP)
                .append(cep)
                .append(EnderecoConstants.TOSTRING_AUDITORIA)
                .append(auditoria)
                .append(EnderecoConstants.TOSTRING_FIM)
                .toString();
    }
}
