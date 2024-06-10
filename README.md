# E-commerce API

This is an e-commerce API.


## Setup

1. **Start Database and Server:**
    - Navigate to the `docker` folder.
    - Run `docker compose up`. This will start the database and the queues server.

2. **Run the Application:**
    - Run the application main class.

3. **Accessing Endpoints:**
    - Spring Security will block access to any endpoint initially.
    - The default user is `user` and the password is generated at random when the application starts (check the console for the password).

4. **Swagger UI:**
    - Access Swagger UI at [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui) to see detailed information about each endpoint.

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
- Store Owners need previous document validation before being allowed to sell.

### System Admins Can:
- See logs.
- Override some permissions to manually address situations.
- Freeze an account for investigation. Frozen accounts can't withdraw money nor sell or buy products.
- Send private message to any user.

## Technologies Used

- **Docker**: Containerization
- **Spring Boot (Kotlin)**: Backend Framework
- **PostgreSQL**: Database
- **RabbitMQ**: Messaging Queue
- **SwaggerUI**: API Documentation
- **Flyway Migrations**: Database Migrations
- **Spring Security**: Security
- **Spring Actuator**: Monitoring
- **Spring Data JPA**: Data Persistence
- **MockK and JUnit**: Unit and Integration tests