package br.com.contmatic.prova.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import br.com.contmatic.prova.util.CpfUtil;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpresaTest {
    private Empresa empresa;
    private static LocalDate dataExemplo;

    @BeforeAll static void iniciarTodos() { dataExemplo = LocalDate.of(2020, 1, 1); }
    @BeforeEach void criarEmpresa() { empresa = new Empresa(); }
    @AfterEach void limparEmpresa() { empresa = null; }
    @AfterAll static void finalizarTodos() { dataExemplo = null; }

    @Test @Order(1) @Timeout(2)
    void deve_guardar_a_razao_social_informada() {
        empresa.setRazaoSocial("Padaria Pão Bom");
        assertThat(empresa.getRazaoSocial(), is("Padaria Pão Bom"));
    }
    @Test @Order(2)
    void nao_deve_aceitar_razao_social_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial("  "));
        assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(null));
    }
    @Test @Order(3)
    void deve_guardar_os_dados_da_empresa() {
        empresa.setCnpj("11222333000181");
        empresa.setCapitalSocial(new BigDecimal("5000.00"));
        empresa.setDataFundacao(dataExemplo);
        empresa.setAtiva(true);
        Telefone telefone = new Telefone();
        telefone.setDdd("11"); telefone.setNumero("999999999");
        empresa.setTelefones(List.of(telefone));
        Endereco endereco = new Endereco(); empresa.setEndereco(endereco);
        Auditoria auditoria = new Auditoria(); empresa.setAuditoria(auditoria);
        assertEquals("11222333000181", empresa.getCnpj());
        assertEquals(new BigDecimal("5000.00"), empresa.getCapitalSocial());
        assertEquals(dataExemplo, empresa.getDataFundacao());
        assertEquals(Boolean.TRUE, empresa.getAtiva());
        assertEquals(List.of(telefone), empresa.getTelefones());
        assertEquals(endereco, empresa.getEndereco());
        assertEquals(auditoria, empresa.getAuditoria());
        empresa.getTelefones().clear();
        assertEquals(1, empresa.getTelefones().size());
        empresa.setTelefones(null); assertEquals(0, empresa.getTelefones().size());
    }
    @Test @Order(4) void nao_deve_aceitar_cnpj_ou_capital_invalidos() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("11222333000180"));
        assertThrows(IllegalArgumentException.class, () -> empresa.setCapitalSocial(new BigDecimal("-1")));
    }
    @Test @Order(5) void deve_aceitar_capital_social_nulo_ou_zero() {
        empresa.setCapitalSocial(null);
        assertNull(empresa.getCapitalSocial());
        empresa.setCapitalSocial(BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, empresa.getCapitalSocial());
    }
    @Test @Order(6) void nao_deve_aceitar_cnpj_nulo_ou_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null));
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("  "));
    }
    @Test @Order(7) void deve_exibir_mensagem_clara_para_razao_social() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> empresa.setRazaoSocial(" "));
        assertEquals("Informe a razão social.", erro.getMessage());
    }
    @Test @Order(8) void deve_normalizar_cnpj_alfanumerico_com_pontuacao() {
        empresa.setCnpj("12.abc.345/01de-35");
        assertEquals("12ABC34501DE35", empresa.getCnpj());
    }
    @Disabled("CPF com pontuação ainda não é aceito pelo validador")
    @Test @Order(9) void deve_aceitar_cpf_com_pontuacao_quando_suportado() {
        assertTrue(CpfUtil.valido("529.982.247-25"));
    }
}
