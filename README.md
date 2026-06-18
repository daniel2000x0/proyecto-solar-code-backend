# Product CRUD API

REST API for user management built with **Spring Boot 4.1** and **Java 26**.

## Tech Stack

- **Java 26** — Latest JDK
- **Spring Boot 4.1.0** — Web, JPA, Validation
- **MySQL** — Database
- **Lombok** — Boilerplate reduction

## Prerequisites

- JDK 26+
- MySQL 8+
- Maven 3.9+

## Quick Start

1. Clone and enter the project:
   ```bash
   git clone <repo-url>
   cd proyecto-solar-code-backend
   ```

2. Set environment variables for DB connection:
   ```bash
   export DB_HOST=localhost
   export DB_PORT=3306
   export DB_NAME=your_database
   export DB_USER=root
   export DB_PASSWORD=your_password
   ```

3. Run:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

| Method | Endpoint               | Description      |
|--------|------------------------|------------------|
| GET    | `/productos/listaruser` | List all users   |
| GET    | `/productos/user/{id}`  | Get user by ID   |
| POST   | `/productos/usersave`   | Create user      |
| PUT    | `/productos/userup/{id}` | Update user     |

## Build

```bash
mvn clean package
java -jar target/product-crud-1-0.0.1-SNAPSHOT.jar
```

## Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/       # REST controllers
│   │   ├── service/          # Business logic
│   │   ├── dao/              # Data access (JPA repositories)
│   │   ├── entity/           # JPA entities
│   │   └── interfaces/       # Service interfaces
│   └── resources/
│       ├── application.properties
│       └── import.sql        # Sample data
└── test/
    └── java/.../ProductCrud1ApplicationTests.java
```
