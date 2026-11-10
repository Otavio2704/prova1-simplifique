package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.constantes.AuditoriaConstantes;
import br.com.contmatic.prova.constantes.DocumentoConstantes;
import br.com.contmatic.prova.constantes.EmpresaConstantes;
import br.com.contmatic.prova.constantes.EnderecoConstantes;
import br.com.contmatic.prova.constantes.TelefoneConstantes;
import br.com.contmatic.prova.constantes.ValidacaoConstantes;

class ClassesDeApoioTest {
    @Test
    void deve_manter_construtores_privados_e_metodos_de_objeto() throws Exception {
        List<Class<?>> classes = List.of(AuditoriaConstantes.class, DocumentoConstantes.class,
                EmpresaConstantes.class, EnderecoConstantes.class, TelefoneConstantes.class, ValidacaoConstantes.class,
                CnpjUtil.class, CpfUtil.class, ValidacaoUtil.class);
        for (Class<?> tipo : classes) {
            Constructor<?> construtor = tipo.getDeclaredConstructor();
            assertTrue(Modifier.isPrivate(construtor.getModifiers()));
            assertEquals(tipo, tipo.getDeclaredMethod("equals", Object.class).getDeclaringClass());
            assertEquals(tipo, tipo.getDeclaredMethod("hashCode").getDeclaringClass());
            assertEquals(tipo, tipo.getDeclaredMethod("toString").getDeclaringClass());
            // Apenas neste teste: reflexão permite verificar classes não instanciáveis normalmente.
            construtor.setAccessible(true);
            Object primeiro = construtor.newInstance();
            Object segundo = construtor.newInstance();
            assertTrue(primeiro.equals(primeiro));
            assertFalse(primeiro.equals(segundo));
            assertNotEquals(primeiro, segundo);
            assertEquals(primeiro.hashCode(), primeiro.hashCode());
            assertEquals(tipo.getSimpleName() + "{}", primeiro.toString());
        }
    }
    @Test
    void deve_proteger_os_pesos_de_documentos_contra_alteracoes_externas() {
        int[] pesos = DocumentoConstantes.cpfPesosPrimeiro();
        int primeiroPeso = pesos[0];
        pesos[0] = -1;
        assertEquals(primeiroPeso, DocumentoConstantes.cpfPesosPrimeiro()[0]);
    }
}
