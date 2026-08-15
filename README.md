markdown
# 🎫 Ticket Support API

A robust, enterprise-grade microservice designed for managing support tickets. This project demonstrates high-level backend engineering principles, focusing on maintainability, observability, and clean architecture.

## 🚀 Key Features

- **Full CRUD Operations:** Seamlessly create, retrieve, and update support tickets.
- **Advanced Observability:** Custom **AOP (Aspect-Oriented Programming)** implementation to monitor and log method execution time.
- **Robust Error Handling:** Centralized exception management using `@RestControllerAdvice` for consistent API responses.
- **Automated Documentation:** Integrated **Swagger/OpenAPI 3** for interactive API exploration.
- **Data Integrity:** Built-in validation using Jakarta Bean Validation and transaction management via Spring Data JPA.

## 🛠 Tech Stack

- **Core:** Java 17, Spring Boot 3.3.2
- **Persistence:** Spring Data JPA, Hibernate, H2 Database (File-based)
- **Architecture:** Clean Architecture, SOLID Principles, Layered Pattern
- **Tools:** Lombok, Maven, SpringDoc OpenAPI, AspectJ (AOP)
- **Validation:** Jakarta Validation (Hibernate Validator)

## 🏗 Architecture & Design Patterns

The project follows **Clean Architecture** principles to ensure loose coupling and high testability.

### 📂 Project Structure
```text
src/main/java/com/example/demo
├───config             # Security and API configuration
├───exception          # Global exception handlers and custom exceptions
├───tickets
│   ├───controller     # REST Endpoints (Entry points)
│   ├───dto
│   │   ├───request    # Request payloads (Records with Validation)
│   │   └───response   # API response models
│   ├───entity         # JPA Entities (Domain Models)
│   ├───enums          # Domain Enums (Status, Priority, etc.)
│   ├───mapper         # DTO <-> Entity transformation logic
│   ├───repository     # Spring Data JPA repositories
│   ├───service        # Business logic (Interfaces & Implementations)
│   └───aspect         # AOP implementations for observability
📐 Design Principles Applied
Single Responsibility (SRP): Separated concerns between Controllers, Services, Mappers, and Entities.
Open/Closed: Uses Enums and flexible structures for easy extensibility.
Liskov Substitution: Implementation of service interfaces.
Interface Segregation: Specific DTOs for specific requests (e.g., CreateTicketRequest vs UpdateTicketStatusRequest).
Dependency Inversion (DIP): High-level modules (Controllers) depend on abstractions (Service Interfaces), not concrete implementations.
🚦 Getting Started
Prerequisites
JDK 17 or higher
Maven 3.6+
Installation & Running
Clone the repository:
bash
   git clone https://github.com/mahdidarzi/ticket_nd_soft_test.git
   cd ticket_nd_soft_test
   
Run the application:
bash
   mvn spring-boot:run
   
Access the API:
Swagger UI: http://localhost:8080/swagger-ui/index.html
H2 Console: http://localhost:8080/h2-console
📖 API Documentation
Endpoints Overview

Method	Endpoint	Description
POST	/api/v1/tickets	Create a new support ticket
GET	/api/v1/tickets	Retrieve all tickets
GET	/api/v1/tickets/{id}	Get specific ticket details
PATCH	/api/v1/tickets/{id}/status	Update ticket status
Example Request (Create Ticket)
POST /api/v1/tickets

json
{
  "title": "Unable to login",
  "description": "User receives a 500 error when attempting to login via OAuth2",
  "priority": "HIGH"
}

👤 Author
Mehdi Darzi
