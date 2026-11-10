package br.com.contmatic.prova.util;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class DocumentosTest {
    @Test void deve_validar_cnpj() {
        assertTrue(CnpjUtil.valido("11222333000181"));
        assertTrue(CnpjUtil.valido("11.222.333/0001-81"));
        assertTrue(CnpjUtil.valido("12ABC34501DE35"));
        assertTrue(CnpjUtil.valido("12.ABC.345/01DE-35"));
        assertTrue(CnpjUtil.valido("12.abc.345/01de-35"));
        assertEquals("12ABC34501DE35", CnpjUtil.normalizar("12.abc.345/01de-35"));
        assertFalse(CnpjUtil.valido("12ABC34501DE34"));
        assertFalse(CnpjUtil.valido("12ABC34501DEA5"));
        assertFalse(CnpjUtil.valido("12-ABC34501DE35"));
        assertTrue(CnpjUtil.valido("00000000000604"));
        assertFalse(CnpjUtil.valido("11222333000191"));
        assertFalse(CnpjUtil.valido("11222333000180"));
        assertFalse(CnpjUtil.valido("11111111111111"));
        assertFalse(CnpjUtil.valido(null));
        assertFalse(CnpjUtil.valido("123"));
        assertFalse(CnpjUtil.valido("1122233300018X"));

    }
    @Test void deve_validar_cpf() {
        assertTrue(CpfUtil.valido("52998224725"));
        assertTrue(CpfUtil.valido("00000000604"));
        assertFalse(CpfUtil.valido("52998224735"));
        assertFalse(CpfUtil.valido("52998224724"));
        assertFalse(CpfUtil.valido("11111111111"));
        assertFalse(CpfUtil.valido(null));
        assertFalse(CpfUtil.valido("123"));
        assertFalse(CpfUtil.valido("5299822472X"));
    }
}
