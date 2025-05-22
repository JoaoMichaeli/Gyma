# 🏋️‍♂️ Gyma-API

**Gyma-API** é o backend da aplicação Gyma, responsável por gerenciar os dados de exercícios físicos e planos de treino personalizados. Desenvolvido com Java e Spring Boot, fornece uma API RESTful para integração com o frontend.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de dados em memória **H2**
- Maven

---

## 🔧 Como Executar Localmente

### 1. Clone o repositório

```bash
git clone https://github.com/JoaoMichaeli/Gyma.git
cd Gyma/API
```

### 2. Execute a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

A interface do banco H2 pode ser acessada em:  
`http://localhost:8080/h2-console`  
(Verifique o `application.properties` para as credenciais e URL)

---

## 🧪 Funcionalidades

### ✅ Implementadas
- Cadastro de exercícios físicos  
- Listagem de exercícios cadastrados

### 🚧 Em desenvolvimento
- Cadastro e edição de planos de treino  
- Associação de exercícios aos planos  
- Autenticação de usuários  
- Dashboard com resumo de treinos

---

## 👨‍💻 Autor

Feito por **João Victor Michaeli de Bem**  
Estudante de **Análise e Desenvolvimento de Sistemas** na **FIAP**  
Apaixonado por desenvolvimento **full stack** e **inteligência artificial**.
