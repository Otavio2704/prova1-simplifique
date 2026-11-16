package br.com.contmatic.prova.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class IgualdadeAtributosTest {
    // Cada mutação altera um único atributo: evita mascarar outros campos no equals.
    private <T> void verificarAtributos(Supplier<T> novo, List<Consumer<T>> alteracoes) {
        for (Consumer<T> alterar : alteracoes) {
            T original = novo.get();
            T diferente = novo.get();
            alterar.accept(diferente);
            assertNotEquals(original, diferente);
            assertNotEquals(diferente, original);
            T mesmaAlteracao = novo.get();
            alterar.accept(mesmaAlteracao);
            assertEquals(diferente, mesmaAlteracao);
            assertEquals(diferente.hashCode(), mesmaAlteracao.hashCode());
        }
    }
    @Test void deve_comparar_cada_atributo_do_endereco() {
        verificarAtributos(Endereco::new, List.of(
            e -> e.setLogradouro("Rua"), e -> e.setNumero("1"),
            e -> e.setCidade("Suzano"), e -> e.setEstado("SP"), e -> e.setCep("00000000"),
            e -> e.setAuditoria(new Auditoria())
        ));
    }
    @Test void deve_comparar_cada_atributo_do_telefone() {
        verificarAtributos(Telefone::new, List.of(t -> t.setDdd("11"), t -> t.setNumero("12345678"),
                t -> t.setAuditoria(new Auditoria())));
    }
    @Test void deve_comparar_cada_atributo_da_auditoria() {
        verificarAtributos(Auditoria::new, List.of(
            a -> a.setCriadoPor("Ana"), a -> a.setDataHoraCriacao(LocalDateTime.of(2020, 1, 1, 10, 30)),
            a -> a.setAlteradoPor("Bia"), a -> a.setDataHoraAlteracao(LocalDateTime.of(2020, 1, 2, 11, 45))
        ));
    }
}
