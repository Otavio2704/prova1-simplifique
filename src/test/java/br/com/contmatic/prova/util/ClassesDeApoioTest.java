package br.com.contmatic.prova.util;

import static org.junit.jupiter.api.Assertions.*;

import br.com.contmatic.prova.constants.AuditoriaConstants;
import br.com.contmatic.prova.constants.DocumentoConstants;
import br.com.contmatic.prova.constants.EmpresaConstants;
import br.com.contmatic.prova.constants.EnderecoConstants;
import br.com.contmatic.prova.constants.TelefoneConstants;
import br.com.contmatic.prova.constants.ValidacaoConstants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ClassesDeApoioTest {
    static Stream<Class<?>> classesDeApoio() {
        return Stream.of(
                AuditoriaConstants.class,
                DocumentoConstants.class,
                EmpresaConstants.class,
                EnderecoConstants.class,
                TelefoneConstants.class,
                ValidacaoConstants.class,
                CnpjUtil.class,
                CpfUtil.class,
                ValidacaoUtil.class);
    }

    @ParameterizedTest
    @MethodSource("classesDeApoio")
    void deve_manter_construtor_privado(Class<?> tipo) throws Exception {
        assertTrue(Modifier.isPrivate(tipo.getDeclaredConstructor().getModifiers()));
    }

    static Stream<Arguments> pesosDeDocumentos() {
        return Stream.of(
                Arguments.of(
                        "CPF primeiro dígito",
                        (Supplier<int[]>) DocumentoConstants::cpfPesosPrimeiro,
                        new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2}),
                Arguments.of(
                        "CPF segundo dígito",
                        (Supplier<int[]>) DocumentoConstants::cpfPesosSegundo,
                        new int[] {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}),
                Arguments.of(
                        "CNPJ primeiro dígito",
                        (Supplier<int[]>) DocumentoConstants::cnpjPesosPrimeiro,
                        new int[] {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}),
                Arguments.of(
                        "CNPJ segundo dígito",
                        (Supplier<int[]>) DocumentoConstants::cnpjPesosSegundo,
                        new int[] {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("pesosDeDocumentos")
    void deve_proteger_pesos_de_documentos_contra_alteracoes_externas(
            String descricao, Supplier<int[]> obterPesos, int[] esperado) {
        int[] primeiraCopia = obterPesos.get();
        int[] segundaCopia = obterPesos.get();
        assertNotSame(primeiraCopia, segundaCopia, descricao);
        assertArrayEquals(esperado, primeiraCopia, descricao);
        Arrays.fill(primeiraCopia, -1);
        assertArrayEquals(esperado, segundaCopia, descricao);
        assertArrayEquals(esperado, obterPesos.get(), descricao);
    }
}
