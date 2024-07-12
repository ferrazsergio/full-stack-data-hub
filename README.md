# Full Stack Data Hub

Este projeto consiste em um sistema Full Stack para gerenciar dados de usuários, composto por três partes principais: um aplicativo batch em Spring Boot para carregar dados de um arquivo JSON para um banco de dados MongoDB, um serviço REST para fornecer APIs CRUD para manipulação desses dados, e um front-end em Angular para visualização dos dados da API.

## Batch Application (Spring Boot)

O aplicativo batch é responsável por carregar os dados de usuários de um arquivo JSON para o MongoDB.

### Funcionalidades

- Deleta todos os dados anteriores do MongoDB.
- Carrega dados do arquivo JSON para o MongoDB.
- Exibe estatísticas de operação após completar o processamento.

## REST API (Spring Boot)

A API REST fornece endpoints para manipulação dos dados de usuários.

### Endpoints

- `POST /users`: Salva novos usuários.
- `GET /users`: Retorna todos os usuários.
- `GET /users/{id}`: Retorna um usuário específico pelo ID.
- `DELETE /users/{id}`: Deleta um usuário pelo ID.

## Angular Front-end

O front-end em Angular apresenta os dados dos usuários da API REST em uma tabela.

### Funcionalidades

- Exibe os dados dos usuários em uma tabela.
- Utiliza serviços REST para obter e exibir os dados.

## Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Node.js e npm (Node Package Manager)
- MongoDB

## Como Executar

1. **Batch Application (Spring Boot)**:
   - Importe o projeto no IntelliJ IDEA ou Eclipse.
   - Configure as variáveis de ambiente ou edite o arquivo `application.properties`.
   - Execute a classe `BatchApplication`.

2. **REST API (Spring Boot)**:
   - Importe o projeto no IntelliJ IDEA ou Eclipse.
   - Configure as variáveis de ambiente ou edite o arquivo `application.properties`.
   - Execute a classe principal da aplicação Spring Boot.

3. **Angular Front-end**:
   - Navegue até a pasta `front end`.
   - Instale as dependências com `npm install`.
   - Inicie o servidor de desenvolvimento com `ng serve`.

4. Abra o navegador e acesse `http://localhost:4200` para ver a aplicação em execução.

---

Este é um guia básico para começar com o projeto 'Full Stack Data Hub'. Sinta-se à vontade para adicionar mais informações, instruções de configuração específicas ou detalhes adicionais conforme necessário.
