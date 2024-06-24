# ToDo List Application

This project is a simple ToDo list application built with Java 17 and Spring Boot. It includes functionalities to create
new ToDo list items and read ToDo list items belonging to a specific user.

## Features

- Create new ToDo items
- Read ToDo items by username
- Elasticsearch integration for searching ToDo items
- Database versioning with Liquibase
- Docker for containerization
- API documentation with Swagger

## Technicals

The application uses:

- MySQL for data storage.
- Elasticsearch for searching TodoItems by username.
- Liquibase for database versioning.
- Docker is used to containerize the application and its dependencies.
- Swagger is integrated for API documentation.

## Prerequisites

- Java 17
- Docker
- Maven 3.9 or above

## Getting Started

### Step 1: Clone the Repository

```bash
git clone https://github.com/AntonyLe23/todo-list-service.git
```

### Step 2: Start application

1. Navigate to root project folder.
2. Maven install:

```shell
mvn clean install -DskipTests
```

3. Start docker service.
4. Run springboot application:

```shell
mvn spring-boot:run
```

5. Verify application:

- Make sure mysql and elasticsearch containers are up:

```shell
docker ps
```

- Health check: http://localhost:8080/actuator/health

### Step 3: Access the Application

- Swagger UI: http://localhost:8080/swagger-ui/index.html

## Contact

For any questions or support, please reach out to phat.lethinh@outlook.com.vn
