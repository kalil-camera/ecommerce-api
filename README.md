PT-BR:

# API de E-commerce

Esta é uma API de e-commerce.

## Tecnologias Utilizadas

- **Docker**: Containerização
- **Spring Boot (Kotlin)**: Framework Backend
- **Redis**: Cache
- **PostgreSQL**: Banco de Dados
- **RabbitMQ**: Fila de Mensagens
- **SwaggerUI**: Documentação da API disponível em http://127.0.0.1:8080/swagger-ui
- **Flyway Migrations**: Migrações de Banco de Dados
- **Spring Security**: Segurança
- **Spring Actuator**: Monitoramento
- **Spring Data JPA**: Persistência de Dados
- **MockK e JUnit**: Testes Unitários e de Integração

## Configuração

1. **Iniciar Banco de Dados e Servidor:**
    - Navegue até a pasta `docker`.
    - Execute `docker compose up`. Isso iniciará o banco de dados e o servidor de filas.

2. **Iniciar a Aplicação**

3. **Acessar Endpoints:**
    - O Spring Security bloqueará o acesso a qualquer endpoint inicialmente e solicitará autenticação.
    - O usuário padrão é `user` e a senha é gerada quando a aplicação inicia (verifique o console para a senha).

4. **Swagger UI:**
    - Acesse o Swagger UI em [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui) para ver informações detalhadas e documentadas sobre cada endpoint.

## Funções Principais

### Criar Conta com Função de Permissão
- **Funções:**
    - Administrador do Sistema
    - Dono da Loja
    - Comprador

### Compradores Podem:
- Navegar pelos produtos.
- Favoritar produtos e ver a lista de favoritos.
- Adicionar produtos ao carrinho de compras.
- Pagar pelos itens no carrinho e receber confirmação por e-mail.

### Donos da Loja Podem:
- Criar, editar ou excluir um produto e definir sua quantidade disponível.
- Ver os pedidos feitos por compradores cuja compra foi confirmada.
- Marcar o pedido como enviado (é necessário fornecer o ID de rastreamento e prova em foto).

### Administradores do Sistema Podem:
- Ver logs.
- Sobrescrever algumas permissões para resolver situações manualmente.
- Congelar uma conta para investigação. Contas congeladas não podem retirar dinheiro nem vender ou comprar produtos.
- Enviar mensagem privada para qualquer usuário.



EN: 

# E-commerce API

This is an e-commerce API.

## Technologies Used

- **Docker**: Containerization
- **Spring Boot (Kotlin)**: Backend Framework
- **Redis**: Cache
- **PostgreSQL**: Database
- **RabbitMQ**: Messaging Queue
- **SwaggerUI**: API Documentation available at http://127.0.0.1:8080/swagger-ui
- **Flyway Migrations**: Database Migrations
- **Spring Security**: Security
- **Spring Actuator**: Monitoring
- **Spring Data JPA**: Data Persistence
- **MockK and JUnit**: Unit and Integration tests

## Setup

1. **Start Database and Server:**
    - Navigate to the `docker` folder.
    - Run `docker compose up`. This will start the database and the queues server.

2. **Boot the Application**

3. **Accessing Endpoints:**
    - Spring Security will block access to any endpoint initially and ask for authentication.
    - The default user is `user` and the password is generated when the application starts (check the console for the password).

4. **Swagger UI:**
    - Access Swagger UI at [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui) to see documented detailed information about each endpoint.

## Main Functions

### Create Account with Permission Role
- **Roles:**
    - System Admin
    - Store Owner
    - Buyer

### Buyers Can:
- Browse products.
- Favorite products and view favorites list.
- Add products to a shopping cart.
- Pay for items in the cart and receive email confirmation.

### Store Owners Can:
- Create, edit, or delete a product and set its available quantity.
- See orders made by buyers which payment has been confirmed.
- Mark order as sent (need to provide tracking id + photo proof)

### System Admins Can:
- See logs.
- Override some permissions to manually address situations.
- Freeze an account for investigation. Frozen accounts can't withdraw money nor sell or buy products.
- Send private message to any user.
