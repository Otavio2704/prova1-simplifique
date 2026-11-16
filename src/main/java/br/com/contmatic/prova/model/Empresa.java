package br.com.contmatic.prova.model;

import java.util.Objects;
import br.com.contmatic.prova.constantes.EmpresaConstantes;
import br.com.contmatic.prova.util.ValidacaoUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.contmatic.prova.util.CnpjUtil;

public class Empresa {
    private String cnpj;
    private String razaoSocial;
    private BigDecimal capitalSocial;
    private LocalDate dataFundacao;
    private Boolean ativa;
    private List<Telefone> telefones = new ArrayList<>();
    private Endereco endereco;
    private Auditoria auditoria;

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        ValidacaoUtil.exigirTexto(cnpj, EmpresaConstantes.CNPJ_OBRIGATORIO);
        if (!CnpjUtil.valido(cnpj)) {
            throw new IllegalArgumentException(EmpresaConstantes.CNPJ_INVALIDO);
        }
        this.cnpj = CnpjUtil.normalizar(cnpj);
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        ValidacaoUtil.exigirTexto(razaoSocial, EmpresaConstantes.RAZAOSOCIAL_OBRIGATORIO);
        this.razaoSocial = razaoSocial;
    }

    public BigDecimal getCapitalSocial() {
        return capitalSocial;
    }
    public void setCapitalSocial(BigDecimal capitalSocial) {
        ValidacaoUtil.exigirNaoNegativo(capitalSocial, EmpresaConstantes.CAPITAL_INVALIDO);
        this.capitalSocial = capitalSocial;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public List<Telefone> getTelefones() {
        return new ArrayList<>(telefones);
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones == null ? new ArrayList<>() : new ArrayList<>(telefones);
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        Empresa outro = (Empresa) objeto;
        // CNPJ não informado não identifica empresas distintas como iguais.
        return cnpj != null && cnpj.equals(outro.cnpj);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }
    @Override
    public String toString() {
        return new StringBuilder(EmpresaConstantes.TOSTRING_INICIO)
                .append(EmpresaConstantes.TOSTRING_CNPJ).append(cnpj)
                .append(EmpresaConstantes.TOSTRING_RAZAOSOCIAL).append(razaoSocial)
                .append(EmpresaConstantes.TOSTRING_CAPITALSOCIAL).append(capitalSocial)
                .append(EmpresaConstantes.TOSTRING_DATAFUNDACAO).append(dataFundacao)
                .append(EmpresaConstantes.TOSTRING_ATIVA).append(ativa)
                .append(EmpresaConstantes.TOSTRING_TELEFONES).append(telefones)
                .append(EmpresaConstantes.TOSTRING_ENDERECO).append(endereco)
                .append(EmpresaConstantes.TOSTRING_AUDITORIA).append(auditoria)
                .append(EmpresaConstantes.TOSTRING_FIM).toString();
    }
}
