# Smart Energy Meter Monitoring System

## Overview

This project is a backend microservice designed to simulate a smart energy meter system. It provides RESTful APIs to ingest, store, and retrieve meter readings, along with structured validation and error handling.

The system is built using Spring Boot and follows a layered architecture to ensure scalability, maintainability, and clean separation of concerns.

---

## Features

* RESTful APIs for meter reading ingestion and retrieval
* PostgreSQL integration for persistent storage
* Centralized exception handling using `@RestControllerAdvice`
* Field-level validation with structured error responses
* Layered architecture (Controller, Service, Repository)
* DTO-based request handling for clean API design
* Scalable and stateless service design

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

---

## Project Structure

```bash
src/main/java/com/smartmeter/meter/
│
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── exception/
├── config/
└── MeterServiceApplication.java
```

---

## API Endpoints

### Create Meter Reading

**POST** `/api/meters/reading`

Request Body:

```json
{
  "meterId": "MTR001",
  "readingValue": 150.5
}
```

Response:

```json
{
  "id": 1,
  "meterId": "MTR001",
  "readingValue": 150.5,
  "timestamp": "2026-04-28T12:00:00"
}
```

---

### Get Meter Readings

**GET** `/api/meters/{meterId}`

Response:

```json
[
  {
    "id": 1,
    "meterId": "MTR001",
    "readingValue": 150.5,
    "timestamp": "2026-04-28T12:00:00"
  }
]
```

---

## Error Handling

### Validation Error (400)

```json
{
  "timestamp": "...",
  "status": 400,
  "error": "Validation Failed",
  "errors": {
    "meterId": "is required",
    "readingValue": "is required"
  },
  "path": "/api/meters/reading"
}
```

---

### Not Found (404)

```json
{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "No readings found for meterId: MTR999",
  "path": "/api/meters/MTR999"
}
```

---

## Getting Started

### Prerequisites

* Java 17
* Maven
* PostgreSQL

---

### Database Setup

```sql
CREATE DATABASE smart_meter;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/smart_meter
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

### Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

---

## Testing

You can test APIs using tools like Postman or curl.

Example:

```bash
curl -X POST http://localhost:8080/api/meters/reading \
-H "Content-Type: application/json" \
-d '{"meterId":"MTR001","readingValue":150.5}'
```

---

## Future Enhancements

* Kafka integration for real-time data streaming
* API documentation using Swagger/OpenAPI
* Docker containerization
* Authentication and authorization
* Multi-service architecture expansion

---

## License

This project is for educational and demonstration purposes.

##Test Screenshot
<img width="1918" height="1030" alt="image" src="https://github.com/user-attachments/assets/d4d4d711-d97d-474d-b50f-4cf00f71eb61" />

