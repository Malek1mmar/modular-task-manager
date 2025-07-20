# 🧩 Task Management System

A clean, modular **Task Management API** built in **Java 21** using **Spring Boot**, following **Hexagonal Architecture** and **Domain-Driven Design** (DDD) principles. This project is structured to prioritize **clean code**, **testability**, and **separation of concerns**.

---

## 📐 Architecture Overview

This project follows **Hexagonal Architecture** (a.k.a. Ports and Adapters), where:

- The **domain** is the core and remains independent of frameworks or infrastructure.
- External layers (web, database, etc.) are **plugged into the core** via interfaces (ports).
- Business logic stays pure and focused, making the system easier to test, evolve, and maintain.