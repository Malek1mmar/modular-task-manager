# 🧩 Task Management System

A clean, modular **Task Management API** built in **Java 21** using **Spring Boot**, following **Hexagonal Architecture** and **Domain-Driven Design** (DDD) principles. This project is structured to prioritize **clean code**, **testability**, and **separation of concerns**.

---

## 📐 Architecture Overview

This project follows **Hexagonal Architecture** (a.k.a. Ports and Adapters), where:

- The **domain** is the core and remains independent of frameworks or infrastructure.
- External layers (web, database, etc.) are **plugged into the core** via interfaces (ports).
- Business logic stays pure and focused, making the system easier to test, evolve, and maintain.

### 📊 Layers


         [ Web Controllers ]
                 |
          [ Application ]
                 |
           [ Domain Core ]
                 |
      [ Database / Messaging / CLI ]

---

## 🧠 Domain-Driven Design (DDD)

This project uses basic DDD building blocks:

| DDD Concept     | Example                                |
|----------------|-----------------------------------------|
| **Entity**      | `Task`                                 |
| **Value Object**| `TaskId`                               |
| **Aggregate**   | `Task` as the root of the aggregate    |
| **Repository**  | `TaskRepository` (domain port)         |
| **Service**     | `TaskService` (application-level logic)|

---

## ✅ Tech Stack

- Java 21 + Spring Boot
- Spring Web (REST)
- Spring Data JPA
- H2 In-Memory Database (for demo)
- JUnit 5 + Mockito (tests)
- Maven
- Docker (optional)

---

## 🚧 Features (Planned)

- Create, update, delete tasks
- Assign tasks to users
- Mark tasks as done/pending
- Filter tasks by status/user
- RESTful API with clean separation
- Full test coverage (unit + integration)

---

## 🧹 Clean Code Principles

- Meaningful names, small methods
- Separation of concerns
- No business logic in controllers
- Domain is free of frameworks
- Testable from the inside out