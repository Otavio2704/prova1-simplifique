# Prova 01 — Modelagem de Empresa

Este projeto foi desenvolvido para a Prova 01, com o objetivo de modelar o domínio de uma empresa e criar testes unitários para verificar o comportamento das classes.

É um projeto Java simples, organizado com Maven. Não possui interface, servidor ou banco de dados: os testes criam os objetos em memória e verificam os resultados das operações.

## Tecnologias utilizadas

* **Java**, com compilação configurada para a versão 25;
* **Maven**, para gerenciar dependências, compilar e executar os testes;
* **JUnit 5 e Hamcrest**, para os testes e suas verificações;
* **JaCoCo**, para gerar o relatório de cobertura.

## Organização do projeto

O pacote base é `br.com.contmatic.prova`:

```text
src/main/java
└── br.com.contmatic.prova
    ├── model       Classes do domínio
    ├── util        Validações
    └── constants   Mensagens e valores fixos

src/test/java       Testes unitários e suíte
pom.xml             Configuração do Maven
```

A pasta `target` é gerada pelo Maven e contém, entre outros arquivos, os resultados dos testes e o relatório de cobertura.

## Modelagem

O pacote `model` contém quatro classes:

* **Empresa**: possui CNPJ, razão social, capital social, data de fundação, situação, telefones, atividades, endereço e auditoria. Telefones são uma lista; atividades são um conjunto de descrições, sem duplicatas. As duas coleções usam cópias defensivas superficiais.
* **Endereco**: possui logradouro, número, cidade, estado, CEP e auditoria.
* **Telefone**: possui DDD, número e auditoria.
* **Auditoria**: registra o responsável e a data e hora de criação e alteração.

Os atributos são privados e acessados por getters e setters. Foram utilizados, entre outros tipos, `String`, `BigDecimal`, `LocalDate`, `LocalDateTime`, `Boolean`, `List` e `Set`.

## Validações

As regras de validação estão separadas em classes utilitárias:

* **`ValidacaoUtil`**: verifica texto obrigatório, valores decimais, formatos, datas e elementos nulos em listas.
* **`CpfUtil`**: valida o formato e os dígitos verificadores do CPF.
* **`CnpjUtil`**: normaliza e valida o formato e os dígitos verificadores do CNPJ.
* **`DigitoVerificadorUtil`**: cálculo interno compartilhado pelos validadores de CPF e CNPJ.

Por exemplo, ao informar uma razão social, o setter de `Empresa` chama `ValidacaoUtil`. Se o texto for nulo ou estiver em branco, uma `IllegalArgumentException` é lançada com a mensagem definida nas constantes. Caso contrário, o valor é guardado.

O CNPJ pode ser numérico ou alfanumérico, com ou sem a pontuação padrão. As letras são convertidas para maiúsculas e o valor é armazenado sem pontuação. O CPF é aceito sem pontuação. As validações não consultam a Receita Federal e não confirmam se um documento está cadastrado ou ativo.

Além de rejeitar texto nulo ou em branco nos campos validados, o projeto aplica estas regras simples:

* **Fundação:** data nula ou até a data atual do sistema; datas futuras são rejeitadas.
* **Auditoria:** se criação e alteração forem informadas, a alteração deve ser igual ou posterior à criação. As datas podem ser preenchidas em qualquer ordem e podem ser nulas.
* **Estado:** sigla de uma UF brasileira; letras minúsculas são aceitas e armazenadas em maiúsculas.
* **CEP:** oito dígitos, com ou sem hífen após os cinco primeiros; o formato informado é preservado.
* **DDD:** dois dígitos. **Telefone:** oito ou nove dígitos, com ou sem hífen antes dos quatro últimos; o formato informado é preservado.
* **Telefones:** a lista pode ser nula (tratada como vazia), mas seus elementos não podem ser nulos. Valores inválidos não substituem os anteriores.

As validações de CEP, DDD e telefone verificam apenas o formato: não confirmam que o CEP ou DDD existe, nem a existência do telefone. Não cobrem números internacionais ou especiais.

## Igualdade e auditoria

Em `Empresa`, `equals` e `hashCode` utilizam o CNPJ normalizado. Assim, duas empresas com o mesmo CNPJ são consideradas iguais; objetos distintos sem CNPJ informado não são considerados iguais. Em `Endereco` e `Telefone`, a comparação considera os dados do endereço ou telefone, sem incluir a auditoria. Em `Auditoria`, considera os próprios campos de auditoria.

A auditoria usa `LocalDateTime` para guardar data **e hora** de criação e alteração. Os valores são informados no objeto; o projeto não os preenche automaticamente.

As classes de modelo também implementam `toString` com `StringBuilder`. Nas classes utilitárias e de constantes, não há sobrescritas de `equals`, `hashCode` ou `toString`: elas têm construtor privado e não são instanciadas no uso normal. Isso prioriza a orientação dos instrutores de remover métodos não utilizados; o enunciado pede esses métodos em todas as classes, portanto esta é uma exceção deliberada.

## Testes

Os testes verificam o armazenamento de dados, as validações e os contratos de igualdade. Eles incluem exemplos de `assertEquals`, `assertThat` com matcher e `assertThrows`.

A classe `EmpresaTest` também demonstra a ordenação de testes, `@Timeout` e os métodos de preparação e finalização. Um teste permanece desativado com `@Disabled` e motivo, para demonstrar o recurso solicitado na atividade.

A classe `SuiteCompleta` reúne os testes do pacote e pode ser executada separadamente.

## Como executar

É necessário um **JDK 25 ou superior**. O projeto foi verificado com Maven 3.10.1; essa versão não apresentou o aviso de depreciação interna observado com Maven 3.9.11 no Java 25. Com o Maven instalado, execute na pasta que contém o `pom.xml`:

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

