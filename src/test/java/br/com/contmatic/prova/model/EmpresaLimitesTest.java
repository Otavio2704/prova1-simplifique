package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EmpresaLimitesTest {
    @ParameterizedTest
    @ValueSource(
            strings = {
                "123",
                "112223330001810",
                "11.222.333000181",
                " 11222333000181",
                "11222333000181 "
            })
    void nao_deve_aceitar_cnpj_com_formato_invalido(String valor) {
        Empresa empresa = new Empresa();
        empresa.setCnpj("11222333000181");
        IllegalArgumentException erro =
                assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(valor));
        assertEquals("Informe um CNPJ válido, com ou sem pontuação.", erro.getMessage());
        assertEquals("11222333000181", empresa.getCnpj());
    }

    @Test
    void nao_deve_aceitar_capital_negativo_e_deve_preservar_valor() {
        Empresa empresa = new Empresa();
        empresa.setCapitalSocial(new BigDecimal("1.00"));
        IllegalArgumentException erro =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> empresa.setCapitalSocial(new BigDecimal("-0.01")));
        assertEquals("Informe um capital social igual ou maior que zero.", erro.getMessage());
        assertEquals(new BigDecimal("1.00"), empresa.getCapitalSocial());
    }

    @Test
    void deve_copiar_lista_na_entrada() {
        Empresa empresa = new Empresa();
        Telefone telefone = new Telefone();
        List<Telefone> original = new ArrayList<>(List.of(telefone));
        empresa.setTelefones(original);
        original.clear();
        assertEquals(List.of(telefone), empresa.getTelefones());
    }

    @Test
    void deve_copiar_lista_na_saida() {
        Empresa empresa = new Empresa();
        Telefone telefone = new Telefone();
        empresa.setTelefones(List.of(telefone));
        empresa.getTelefones().clear();
        assertEquals(List.of(telefone), empresa.getTelefones());
    }

    @Test
    void deve_copiar_conjunto_na_entrada() {
        Empresa empresa = new Empresa();
        Set<String> original = new HashSet<>(Set.of("Comércio"));
        empresa.setAtividades(original);
        original.add("Serviços");
        assertEquals(Set.of("Comércio"), empresa.getAtividades());
    }

    @Test
    void deve_copiar_conjunto_na_saida() {
        Empresa empresa = new Empresa();
        empresa.setAtividades(Set.of("Comércio"));
        empresa.getAtividades().clear();
        assertEquals(Set.of("Comércio"), empresa.getAtividades());
    }

    @Test
    void deve_tratar_conjunto_nulo_como_vazio() {
        Empresa empresa = new Empresa();
        empresa.setAtividades(Set.of("Comércio"));
        empresa.setAtividades(null);
        assertEquals(Set.of(), empresa.getAtividades());
    }
}
