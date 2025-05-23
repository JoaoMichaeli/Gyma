# Gyma-API

Gyma-API é a API RESTful construída com Java Spring Boot que serve como backend para a aplicação Gyma. Ela gerencia usuários, planos de treino e exercícios, fornecendo endpoints seguros com autenticação HTTP Basic.

---

## Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security (HTTP Basic Authentication)
- Spring Data JPA com Hibernate
- Banco de dados H2 para desenvolvimento
- Maven para gerenciamento de dependências
- MapStruct para mapeamento DTO
- Swagger/OpenAPI para documentação

---

## Funcionalidades principais

- Autenticação HTTP Basic para proteger endpoints
- CRUD completo para usuários, planos e exercícios
- Relacionamento entre entidades: Planos possuem vários Exercícios
- Seeders para popular banco de dados com dados de teste
- Tratamento de erros e mensagens claras para o frontend
- Paginação e filtros básicos
- Suporte para CORS para comunicação com frontend

---

## Estrutura do projeto

- `src/main/java/com/gymaapi`
  - `controller` — endpoints REST controllers
  - `service` — regras de negócio e serviços
  - `repository` — interfaces de persistência JPA
  - `model` — entidades JPA e DTOs
  - `config` — configurações de segurança e CORS
  - `exception` — tratamento centralizado de erros

---

## Como executar localmente

### Pré-requisitos

- Java 17 ou superior instalado
- Maven 3+
- Banco de dados configurado (padrão H2 em memória)

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/Gyma-API.git
cd Gyma-API
```

2. Build e rodar:

```bash
mvn clean install
mvn spring-boot:run
```

3. A API estará disponível em `http://localhost:8080`

---

## Endpoints principais

- `POST /users/login` — login (pode usar HTTP Basic)
- `GET /plans` — lista planos do usuário autenticado
- `POST /plans` — cria novo plano
- `GET /plans/{id}` — detalhes do plano
- `PUT /plans/{id}` — editar plano
- `DELETE /plans/{id}` — remover plano
- `POST /plans/{planId}/exercises` — adicionar exercício a plano
- `PUT /exercises/{id}` — editar exercício
- `DELETE /exercises/{id}` — remover exercício

---

## Configurações importantes

- A autenticação é feita via HTTP Basic, configurada no Spring Security
- Cross-origin configurado para permitir requisições do frontend (localhost:3000)
- Banco H2 é usado para desenvolvimento; trocar para MySQL/Postgres em produção
- Arquivo `application.properties` ou `application.yml` para configuração de banco, porta e segurança
- Dados seeders criam usuários, planos e exercícios iniciais para testes
