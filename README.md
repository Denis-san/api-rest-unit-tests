# Introdução

Este repositório foi criado com o objetivo de explorar e aprimorar habilidades em testes automatizados em Java utilizando o ecossistema Spring. 

O projeto consiste em aplicar práticas de teste unitário e teste de integração em uma API RESTful construída anteriormente. Os testes unitários têm como finalidade verificar se unidades individuais de código, como métodos e classes, funcionam conforme o esperado, enquanto os testes de integração garantem o correto funcionamento das diferentes partes do sistema em conjunto, incluindo a interação com a API.

Ao realizar este projeto, espera-se aprimorar a compreensão sobre a importância dos testes automatizados na garantia da qualidade do software, além de ganhar experiência prática na implementação e execução de testes em um ambiente controlado. O aprendizado adquirido aqui pode ser aplicado em projetos futuros, contribuindo para o desenvolvimento de software mais confiável e robusto.

Sinta-se à vontade para explorar o código, experimentar diferentes abordagens de teste e contribuir com melhorias para este projeto. O foco principal é aprender e aprimorar habilidades em testes automatizados em Java com Spring Boot.

# Executando a aplicação e os testes

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- Java Development Kit (JDK) para compilar e executar o código Java (Versão do JDK utilizado: 17).
- Maven para gerenciamento de dependências e execução de scripts.
- A API REST que será testada deve estar em execução localmente ou em um ambiente acessível.
- Um ambiente de desenvolvimento ou teste configurado para execução dos testes.

### Configuração
Clone este repositório para o seu ambiente local:

```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

Navegue até o diretório do projeto:

```
cd seu-repositorio
```

Importe o projeto em sua IDE preferida.

# Executando os Testes Unitários
Os testes unitários visam testar unidades individuais de código, como métodos e classes, isoladamente do restante do sistema. Eles são escritos utilizando o JUnit.

Para executar os testes unitários, utilize sua IDE ou o seguinte comando Maven:

```
mvn test
```
Os resultados dos testes serão exibidos no console da sua IDE ou no terminal, indicando quais testes passaram e quais falharam. Certifique-se de que a API REST que será testada esteja em execução localmente ou em um ambiente acessível antes de executar os testes de integração.
