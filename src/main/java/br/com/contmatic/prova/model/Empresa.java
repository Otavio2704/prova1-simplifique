package br.com.contmatic.prova.model;

import br.com.contmatic.prova.constants.EmpresaConstants;
import br.com.contmatic.prova.util.CnpjUtil;
import br.com.contmatic.prova.util.ValidacaoUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Empresa {
    private String cnpj;
    private String razaoSocial;
    private BigDecimal capitalSocial;
    private LocalDate dataFundacao;
    private Boolean ativa;
    private List<Telefone> telefones = new ArrayList<>();
    private Set<String> atividades = new HashSet<>();
    private Endereco endereco;
    private Auditoria auditoria;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        ValidacaoUtil.exigirTexto(cnpj, EmpresaConstants.CNPJ_OBRIGATORIO);
        String cnpjNormalizado = CnpjUtil.normalizarSeValido(cnpj);
        if (cnpjNormalizado == null) {
            throw new IllegalArgumentException(EmpresaConstants.CNPJ_INVALIDO);
        }
        this.cnpj = cnpjNormalizado;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        ValidacaoUtil.exigirTexto(razaoSocial, EmpresaConstants.RAZAOSOCIAL_OBRIGATORIO);
        this.razaoSocial = razaoSocial;
    }

    public BigDecimal getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(BigDecimal capitalSocial) {
        ValidacaoUtil.exigirNaoNegativo(capitalSocial, EmpresaConstants.CAPITAL_INVALIDO);
        this.capitalSocial = capitalSocial;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        ValidacaoUtil.exigirDataNaoFutura(
                dataFundacao, LocalDate.now(), EmpresaConstants.DATA_FUNDACAO_FUTURA);
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
        List<Telefone> copia = telefones == null ? new ArrayList<>() : new ArrayList<>(telefones);
        ValidacaoUtil.exigirElementosNaoNulos(copia, EmpresaConstants.TELEFONE_NULO);
        this.telefones = copia;
    }

    public Set<String> getAtividades() {
        return new HashSet<>(atividades);
    }

    public void setAtividades(Set<String> atividades) {
        this.atividades = atividades == null ? new HashSet<>() : new HashSet<>(atividades);
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
        return new StringBuilder(EmpresaConstants.TOSTRING_INICIO)
                .append(EmpresaConstants.TOSTRING_CNPJ)
                .append(cnpj)
                .append(EmpresaConstants.TOSTRING_RAZAOSOCIAL)
                .append(razaoSocial)
                .append(EmpresaConstants.TOSTRING_CAPITALSOCIAL)
                .append(capitalSocial)
                .append(EmpresaConstants.TOSTRING_DATAFUNDACAO)
                .append(dataFundacao)
                .append(EmpresaConstants.TOSTRING_ATIVA)
                .append(ativa)
                .append(EmpresaConstants.TOSTRING_TELEFONES)
                .append(telefones)
                .append(EmpresaConstants.TOSTRING_ATIVIDADES)
                .append(atividades)
                .append(EmpresaConstants.TOSTRING_ENDERECO)
                .append(endereco)
                .append(EmpresaConstants.TOSTRING_AUDITORIA)
                .append(auditoria)
                .append(EmpresaConstants.TOSTRING_FIM)
                .toString();
    }
}
