# Sistema de Agendamento de Transferências

## Descrição

Aplicação desenvolvida para realização de agendamentos de transferências financeiras, permitindo o cadastro de novas transferências e a consulta do extrato de agendamentos realizados.

---

## Decisões Arquiteturais

### Backend

O backend foi desenvolvido utilizando Spring Boot seguindo uma arquitetura em camadas, visando a separação de responsabilidades e a facilidade de manutenção.

Estrutura adotada:

```text
controller
service
repository
model
dto
exception
```

Principais decisões:

- Utilização da camada Service para centralização das regras de negócio;
- Utilização de DTO para recebimento dos dados da requisição;
- Tratamento global de exceções utilizando `@ControllerAdvice`;
- Persistência em banco de dados H2 em memória, conforme solicitado no desafio;
- Implementação de validações de negócio, como impedimento de transferências entre a mesma conta.

### Frontend

O frontend foi desenvolvido em Angular utilizando Standalone Components.

Estrutura adotada:

```text
components
models
services
```

Principais decisões:

- Criação de um serviço responsável pela comunicação com a API;
- Separação entre componente de cadastro e componente de listagem das transferências;
- Atualização automática da listagem após um novo agendamento.

---

## Tecnologias Utilizadas

### Backend

- Java 11
- Spring Boot 2.7.18
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok

### Frontend

- Angular 17
- TypeScript
- CSS3
- HttpClient
- FormsModule

### Ferramentas

- IntelliJ IDEA
- Postman
- Git
- GitHub

---

## Estrutura do Projeto

```text
sistema-agendamento-transferencias

backend/
frontend/
README.md
```

---

## Executando o Backend

Acessar a pasta:

```bash
cd backend
```

Executar a aplicação:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

Console do H2:

```text
http://localhost:8080/h2-console
```

Configurações:

```text
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha:
```

---

## Executando o Frontend

Acessar a pasta:

```bash
cd frontend
```

Instalar dependências:

```bash
npm install
```

Executar:

```bash
ng serve
```

A aplicação estará disponível em:

```text
http://localhost:4200
```

---

## Funcionalidades

- Agendamento de transferências financeiras;
- Cálculo automático da taxa conforme regra de negócio;
- Consulta do extrato de transferências cadastradas;
- Validação de contas e regras de negócio;
- Tratamento amigável de erros.
