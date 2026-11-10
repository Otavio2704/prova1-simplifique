# Prova 01 — Modelagem de Empresa

Este projeto foi desenvolvido para a Prova 01, com o objetivo de modelar o domínio de uma empresa e testar as regras implementadas. É um projeto Java simples, organizado com Maven, sem interface, servidor ou banco de dados.

## Como o projeto está organizado

O pacote base é `br.com.contmatic.prova`:

- **`model`**: classes `Empresa`, `Endereco`, `Telefone` e `Auditoria`.
- **`util`**: validações de CPF, CNPJ e campos básicos.
- **`constantes`**: mensagens e valores fixos usados pelas classes.
- **`src/test/java`**: testes unitários e suíte de testes.

## Como funciona

Os testes criam objetos das classes e informam os dados pelos setters. Antes de guardar alguns valores, os setters chamam as utilitárias de validação. Se o valor for inválido, uma exceção é lançada; os testes conferem tanto os casos aceitos quanto os rejeitados.

A classe `Auditoria` guarda o responsável e a data e hora de criação e alteração. Em `Empresa`, o CNPJ é usado para definir a igualdade entre objetos: duas empresas com o mesmo CNPJ normalizado são consideradas iguais. Empresas distintas sem CNPJ não são consideradas iguais.

O validador aceita CNPJ numérico ou alfanumérico, com ou sem a pontuação padrão. O valor é armazenado sem pontuação e em maiúsculas. O CPF é validado sem pontuação. As validações conferem formato e dígitos verificadores, mas não consultam a Receita Federal.

## Como executar

É necessário um **JDK 11 ou superior**. Com o Maven instalado, execute o comando na pasta que contém o `pom.xml`:

```bash
mvn clean verify
```

No STS, também é possível clicar com o botão direito no projeto → **Run As → Maven build...** e informar `clean verify` em **Goals**. O campo **Base directory** deve apontar para a pasta que contém o `pom.xml`.

A suíte `SuiteCompleta` pode ser executada separadamente com **Run As → JUnit Test**. Após `clean verify`, o relatório de cobertura fica em:

```text
target/site/jacoco/index.html
```

Os testes usam **JUnit 5** e **Hamcrest**, e a cobertura é gerada pelo **JaCoCo**. Um teste está desativado com `@Disabled`, com motivo, para demonstrar o recurso solicitado na atividade.

## Decisão sobre as classes de apoio

Os métodos `equals`, `hashCode` e `toString` também foram sobrescritos nas classes utilitárias e de constantes por uma leitura literal da regra que pede esses métodos em “todas as classes”. Como essas classes têm construtores privados e não são instanciadas no uso normal, esses overrides seriam normalmente desnecessários.
