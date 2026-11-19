package br.com.contmatic.prova.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import br.com.contmatic.prova.util.CpfUtil;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpresaTest {
    private Empresa empresa;
    private static LocalDate dataExemplo;

    @BeforeAll
    static void iniciarTodos() {
        dataExemplo = LocalDate.of(2020, 1, 1);
    }

    @BeforeEach
    void criarEmpresa() {
        empresa = new Empresa();
    }

    @AfterEach
    void limparEmpresa() {
        empresa = null;
    }

    @AfterAll
    static void finalizarTodos() {
        dataExemplo = null;
    }

    @Test
    @Order(1)
    @Timeout(2)
    void deve_guardar_a_razao_social_informada() {
        empresa.setRazaoSocial("Padaria Pão Bom");
        assertThat(empresa.getRazaoSocial(), is("Padaria Pão Bom"));
    }

    @Test
    @Order(2)
    void deve_guardar_cnpj_informado() {
        empresa.setCnpj("11222333000181");
        assertEquals("11222333000181", empresa.getCnpj());
    }

    @Test
    @Order(3)
    void deve_guardar_capital_social_informado() {
        empresa.setCapitalSocial(new BigDecimal("5000.00"));
        assertEquals(new BigDecimal("5000.00"), empresa.getCapitalSocial());
    }

    @Test
    @Order(4)
    void deve_guardar_data_fundacao_informada() {
        empresa.setDataFundacao(dataExemplo);
        assertEquals(dataExemplo, empresa.getDataFundacao());
    }

    @Test
    @Order(5)
    void deve_guardar_situacao_informada() {
        empresa.setAtiva(true);
        assertEquals(Boolean.TRUE, empresa.getAtiva());
    }

    @Test
    @Order(6)
    void deve_guardar_telefones_informados() {
        Telefone telefone = new Telefone();
        telefone.setDdd("11");
        telefone.setNumero("999999999");
        empresa.setTelefones(List.of(telefone));
        assertEquals(List.of(telefone), empresa.getTelefones());
    }

    @Test
    @Order(7)
    void deve_tratar_lista_nula_como_vazia() {
        empresa.setTelefones(null);
        assertEquals(List.of(), empresa.getTelefones());
    }

    @Test
    @Order(8)
    void deve_guardar_endereco_informado() {
        Endereco endereco = new Endereco();
        empresa.setEndereco(endereco);
        assertSame(endereco, empresa.getEndereco());
    }

    @Test
    @Order(9)
    void deve_guardar_auditoria_informada() {
        Auditoria auditoria = new Auditoria();
        empresa.setAuditoria(auditoria);
        assertSame(auditoria, empresa.getAuditoria());
    }

    @Test
    @Order(10)
    void nao_deve_aceitar_cnpj_com_digito_invalido() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("11222333000180"));
    }

    @Test
    @Order(11)
    void nao_deve_aceitar_capital_negativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> empresa.setCapitalSocial(new BigDecimal("-1")));
    }

    @Test
    @Order(12)
    void deve_aceitar_capital_social_nulo() {
        empresa.setCapitalSocial(null);
        assertNull(empresa.getCapitalSocial());
    }

    @Test
    @Order(13)
    void deve_aceitar_capital_social_zero() {
        empresa.setCapitalSocial(BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, empresa.getCapitalSocial());
    }

    @Test
    @Order(14)
    void deve_normalizar_cnpj_alfanumerico_com_pontuacao() {
        empresa.setCnpj("12.abc.345/01de-35");
        assertEquals("12ABC34501DE35", empresa.getCnpj());
    }

    @Disabled("CPF com pontuação ainda não é aceito pelo validador")
    @Test
    @Order(15)
    void deve_aceitar_cpf_com_pontuacao_quando_suportado() {
        assertTrue(CpfUtil.valido("529.982.247-25"));
    }
}
