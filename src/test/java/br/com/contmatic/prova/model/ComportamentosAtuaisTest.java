package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

// Documenta comportamentos existentes; não representa novas validações de negócio.
class ComportamentosAtuaisTest {
    @Test
    void deve_guardar_atividades_distintas_do_conjunto_informado() {
        Set<String> atividades = new HashSet<>();
        atividades.add("Comércio");
        atividades.add("Serviços");
        Empresa empresa = new Empresa();
        empresa.setAtividades(atividades);
        assertEquals(Set.of("Comércio", "Serviços"), empresa.getAtividades());
        assertEquals(2, empresa.getAtividades().size());
    }

    @Test
    void deve_retornar_conjunto_que_nao_adiciona_atividade_duplicada() {
        Empresa empresa = new Empresa();
        empresa.setAtividades(Set.of("Comércio"));
        Set<String> copia = empresa.getAtividades();
        assertFalse(copia.add("Comércio"));
        assertEquals(Set.of("Comércio"), copia);
        assertEquals(Set.of("Comércio"), empresa.getAtividades());
    }

    @Test
    void deve_exibir_atividades_no_to_string() {
        Empresa empresa = new Empresa();
        empresa.setAtividades(Set.of("Comércio"));
        assertTrue(empresa.toString().contains("atividades=[Comércio]"));
    }
}
