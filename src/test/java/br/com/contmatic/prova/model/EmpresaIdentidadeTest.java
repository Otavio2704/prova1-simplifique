package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmpresaIdentidadeTest {
    @Test void deve_considerar_empresas_com_mesmo_cnpj_iguais() {
        Empresa primeira = new Empresa();
        primeira.setCnpj("12.ABC.345/01DE-35");
        primeira.setRazaoSocial("Nome original");
        Empresa segunda = new Empresa();
        segunda.setCnpj("12abc34501de35");
        segunda.setRazaoSocial("Nome diferente");
        assertEquals(primeira, segunda);
        assertEquals(segunda, primeira);
        assertEquals(primeira.hashCode(), segunda.hashCode());
    }
    @Test void nao_deve_igualar_empresas_sem_cnpj_ou_com_cnpj_diferente() {
        Empresa semCnpj = new Empresa();
        Empresa outraSemCnpj = new Empresa();
        Empresa numerica = new Empresa(); numerica.setCnpj("11222333000181");
        Empresa alfanumerica = new Empresa(); alfanumerica.setCnpj("12ABC34501DE35");
        assertEquals(semCnpj, semCnpj);
        assertNotEquals(semCnpj, outraSemCnpj);
        assertNotEquals(semCnpj, numerica);
        assertNotEquals(numerica, semCnpj);
        assertNotEquals(numerica, alfanumerica);
        assertNotEquals(numerica, null);
        assertNotEquals(numerica, new Telefone());
    }
    @Test void deve_tratar_cnpj_numerico_formatado_como_mesma_identidade() {
        Empresa primeira = new Empresa(); primeira.setCnpj("11.222.333/0001-81");
        Empresa segunda = new Empresa(); segunda.setCnpj("11222333000181");
        assertEquals(primeira, segunda);
        assertEquals(primeira.hashCode(), segunda.hashCode());
    }
    @Test void nao_deve_substituir_cnpj_ja_guardado_por_valor_invalido() {
        Empresa empresa = new Empresa(); empresa.setCnpj("11222333000181");
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("12ABC34501DE34"));
        assertEquals("11222333000181", empresa.getCnpj());
    }
}
