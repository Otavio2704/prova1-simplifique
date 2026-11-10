# Prova 01 — Modelagem de Empresa

Este projeto foi desenvolvido para a Prova 01, com o objetivo de modelar o domínio de uma empresa e criar testes unitários para verificar o comportamento das classes.

É um projeto Java simples, organizado com Maven. Não possui interface, servidor ou banco de dados: os testes criam os objetos em memória e verificam os resultados das operações.

## Tecnologias utilizadas

- **Java**, com compilação configurada para a versão 11;
- **Maven**, para gerenciar dependências, compilar e executar os testes;
- **JUnit 5 e Hamcrest**, para os testes e suas verificações;
- **JaCoCo**, para gerar o relatório de cobertura.

## Organização do projeto

O pacote base é `br.com.contmatic.prova`:

```text
src/main/java
└── br.com.contmatic.prova
    ├── model       Classes do domínio
    ├── util        Validações
    └── constantes  Mensagens e valores fixos

src/test/java       Testes unitários e suíte
pom.xml             Configuração do Maven
```

A pasta `target` é gerada pelo Maven e contém, entre outros arquivos, os resultados dos testes e o relatório de cobertura.

## Modelagem

O pacote `model` contém quatro classes:

- **Empresa**: possui CNPJ, razão social, capital social, data de fundação, situação, telefones, endereço e auditoria.
- **Endereco**: possui logradouro, número, cidade, estado, CEP e auditoria.
- **Telefone**: possui DDD, número e auditoria.
- **Auditoria**: registra o responsável e a data e hora de criação e alteração.

Os atributos são privados e acessados por getters e setters. Foram utilizados, entre outros tipos, `String`, `BigDecimal`, `LocalDate`, `LocalDateTime`, `Boolean` e `List`.

## Validações

As regras de validação estão separadas em classes utilitárias:

- **`ValidacaoUtil`**: verifica texto obrigatório e valor decimal não negativo.
- **`CpfUtil`**: valida o formato e os dígitos verificadores do CPF.
- **`CnpjUtil`**: normaliza e valida o formato e os dígitos verificadores do CNPJ.

Por exemplo, ao informar uma razão social, o setter de `Empresa` chama `ValidacaoUtil`. Se o texto for nulo ou estiver em branco, uma `IllegalArgumentException` é lançada com a mensagem definida nas constantes. Caso contrário, o valor é guardado.

O CNPJ pode ser numérico ou alfanumérico, com ou sem a pontuação padrão. As letras são convertidas para maiúsculas e o valor é armazenado sem pontuação. O CPF é aceito sem pontuação. As validações não consultam a Receita Federal e não confirmam se um documento está cadastrado ou ativo.

Os campos de texto de endereço e telefone são verificados contra valores nulos e em branco, mas não possuem validações específicas de máscara ou tamanho.

## Igualdade e auditoria

Em `Empresa`, `equals` e `hashCode` utilizam o CNPJ normalizado. Assim, duas empresas com o mesmo CNPJ são consideradas iguais; objetos distintos sem CNPJ informado não são considerados iguais. Nas demais classes de modelo, a comparação considera seus respectivos atributos.

A auditoria usa `LocalDateTime` para guardar data **e hora** de criação e alteração. Os valores são informados no objeto; o projeto não os preenche automaticamente.

As classes de modelo também implementam `toString` com `StringBuilder`. Os três métodos foram sobrescritos nas classes de apoio por uma leitura literal da regra de “todas as classes”, embora essas classes tenham construtores privados e não sejam instanciadas no uso normal.

## Testes

Os testes verificam o armazenamento de dados, as validações e os contratos de igualdade. Eles incluem exemplos de `assertEquals`, `assertThat` com matcher e `assertThrows`.

A classe `EmpresaTest` também demonstra a ordenação de testes, `@Timeout` e os métodos de preparação e finalização. Um teste permanece desativado com `@Disabled` e motivo, para demonstrar o recurso solicitado na atividade.

A classe `SuiteCompleta` reúne os testes do pacote e pode ser executada separadamente.

## Como executar

É necessário um **JDK 11 ou superior**. Com o Maven instalado, execute na pasta que contém o `pom.xml`:

```bash
mvn clean verify
```

No STS, clique com o botão direito no projeto → **Run As → Maven build...** e informe `clean verify` no campo **Goals**. O **Base directory** deve apontar para a pasta que contém o `pom.xml`.

Para executar a suíte separadamente, clique com o botão direito em `SuiteCompleta` → **Run As → JUnit Test**.

Após a execução do Maven, o relatório do JaCoCo fica em:

```text
target/site/jacoco/index.html
```

Abra o arquivo e selecione o pacote `br.com.contmatic.prova.model` para conferir a cobertura. A cobertura indica quais partes do código foram executadas, mas não garante, sozinha, que todos os cenários possíveis foram testados.
