package br.com.contmatic.prova.model;

import java.util.Objects;
import br.com.contmatic.prova.constantes.EnderecoConstantes;
import br.com.contmatic.prova.util.ValidacaoUtil;

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
        ValidacaoUtil.exigirTexto(logradouro, EnderecoConstantes.LOGRADOURO_OBRIGATORIO);
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        ValidacaoUtil.exigirTexto(numero, EnderecoConstantes.NUMERO_OBRIGATORIO);
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        ValidacaoUtil.exigirTexto(cidade, EnderecoConstantes.CIDADE_OBRIGATORIO);
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        ValidacaoUtil.exigirTexto(estado, EnderecoConstantes.ESTADO_OBRIGATORIO);
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        ValidacaoUtil.exigirTexto(cep, EnderecoConstantes.CEP_OBRIGATORIO);
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
        return Objects.equals(logradouro, outro.logradouro) &&
                Objects.equals(numero, outro.numero) &&
                Objects.equals(cidade, outro.cidade) &&
                Objects.equals(estado, outro.estado) &&
                Objects.equals(cep, outro.cep) &&
                Objects.equals(auditoria, outro.auditoria);
    }
    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero, cidade, estado, cep, auditoria);
    }
    @Override
    public String toString() {
        return new StringBuilder(EnderecoConstantes.TOSTRING_INICIO)
                .append(EnderecoConstantes.TOSTRING_LOGRADOURO).append(logradouro)
                .append(EnderecoConstantes.TOSTRING_NUMERO).append(numero)
                .append(EnderecoConstantes.TOSTRING_CIDADE).append(cidade)
                .append(EnderecoConstantes.TOSTRING_ESTADO).append(estado)
                .append(EnderecoConstantes.TOSTRING_CEP).append(cep)
                .append(EnderecoConstantes.TOSTRING_AUDITORIA).append(auditoria)
                .append(EnderecoConstantes.TOSTRING_FIM).toString();
    }
}
