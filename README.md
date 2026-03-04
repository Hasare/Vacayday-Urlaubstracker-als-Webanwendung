# Vacayday – Urlaubstracker als Webanwendung







Vacayday is a simple web application that allows employees to record their vacation days in a shared table.

The purpose of the application is not to request or approve vacation, but simply to inform other team members about absences. Employees enter their already approved vacation days so that colleagues can see when someone will be unavailable.

There is no approval workflow. Vacation entries represent days that are already approved and are entered only to inform other team members.

## Tech Stack

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Maven

Vaadin

## Project Purpose

This application was developed as the final project for my IHK apprenticeship as a Software Developer (Fachinformatiker für Anwendungsentwicklung).

The project demonstrates the implementation of a database-driven web application using Java and Spring Boot.

## Features

- User authentication (login)
- Role-based access (**Admin / User**)

- **Admin**
    - can register new users (Register page)
    - can add their own vacation days

- **User**
    - can add their own vacation days

- Shared vacation overview table (team-wide visibility of absences)

- After login, users are redirected based on their role
    - **Admin:** Home + Register page
    - **User:** Home page only

## Project Structure
```
src/main/java
│
└─ com.example.vacayday
    ├─ backend
    │  ├─ config        -> startup/config (e.g. DataInitializer)
    │  ├─ entity        -> JPA entities
    │  └─ service       -> business logic + repositories
    │
    └─ ui
        └─ views         -> Vaadin user interface 
```
## Requirements

To run this project you need:

Java 17

PostgreSQL

Maven

## Database Configuration

Example configuration in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/vacayday

spring.datasource.username=your_username

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

## Default User

When the application starts for the first time and the database is empty, a default administrator account is created.

Username: admin
Password: admin

## Project Status

This project is completed and was submitted as part of the final examination for the IHK qualification “Fachinformatiker für Anwendungsentwicklung.”

It represents the development skills at the time of the training and serves as a reference project.

## Author

Hasan Rezai