# Microserviço de Autenticação e Autorização com Spring Boot e Spring Security

Este é um projeto de exemplo de um microserviço de autenticação e autorização desenvolvido com Spring Boot, Spring Security, Java 17, MongoDB e Docker Compose. O objetivo deste microserviço é fornecer funcionalidades de registro de usuários, autenticação via JWT e autorização baseada em papéis (roles).

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- MongoDB
- Docker Compose

## Funcionalidades Principais

1. Registro de Usuários: Os usuários podem se registrar fornecendo um nome de usuário, e-mail e senha. O serviço valida e armazena essas informações no banco de dados MongoDB.

2. Autenticação JWT: O serviço gera um token JWT (JSON Web Token) para usuários autenticados. Este token é usado para autenticação em solicitações subsequentes.

3. Autorização com Papéis (Roles): O serviço suporta diferentes papéis de usuário, como usuário regular e administrador. As autorizações de acesso a recursos são baseadas nos papéis atribuídos a cada usuário.

## Novas Features (Em Desenvolvimento)

1. Cadastro de Pessoa: Adição da funcionalidade de cadastro de pessoa física, incluindo CPF, nome, etc.

## Estrutura do Projeto

O projeto segue uma arquitetura baseada em Domain-Driven Design (DDD) e segue os princípios SOLID. As principais camadas do projeto incluem:

- **Controller**: Responsável por receber e responder às solicitações HTTP.
- **Service**: Contém a lógica de negócios da aplicação, incluindo a lógica de autenticação, autorização e manipulação de dados.
- **Repository**: Responsável pela interação com o banco de dados MongoDB.
- **DTO**: Contém objetos de transferência de dados para comunicação entre camadas.
- **Security**: Configuração do Spring Security para autenticação e autorização.

## Configuração do Ambiente

1. Certifique-se de ter o Java 17 instalado em sua máquina.
2. Instale o Docker e o Docker Compose para a execução do MongoDB e outros contêineres necessários.
3. Clone o repositório do projeto.
4. O docker-compose que está no projeto, atualmente, baixa e inicializa um container do kong apenas.

## Como Executar

1. Importe o projeto em sua IDE preferida.
2. Execute a classe principal `Application.java` para iniciar o microserviço.
3. O serviço estará acessível em `http://localhost:8080`.

## Testes

O projeto inclui testes automatizados para garantir a qualidade do código. Para executar os testes, basta executar a classe de teste apropriada em sua IDE ou usar o comando `mvn test`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou relatar problemas.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
