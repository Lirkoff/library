# Library App  
[![Java](https://img.shields.io/badge/Java-11+-blue.svg)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7+-brightgreen.svg)](https://spring.io/projects/spring-boot)  
[![React](https://img.shields.io/badge/React-18+-61DAFB.svg)](https://reactjs.org/)  
[![TypeScript](https://img.shields.io/badge/TypeScript-4.5+-blue.svg)](https://www.typescriptlang.org/)  
[![MySQL](https://img.shields.io/badge/MySQL-8+-blue.svg)](https://www.mysql.com/)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A **full-stack** application for users to register, rent, and return books. The project is built with **React + TypeScript** on the frontend, **Java + Spring Boot** on the backend, and **MySQL** as the database. **Spring Security** is used for authentication and authorization, and **Stripe** is integrated for payment processing.

---

## Table of Contents

1. [Features](#features)  
2. [Architecture](#architecture)  
3. [Tech Stack](#tech-stack)  

---

## Features

- **User Registration & Login** – secure sign-up and sign-in with Spring Security  
- **Role-Based Authorization** – three roles: **USER**, **MODERATOR**, and **ADMIN**  
- **Book Management** – CRUD (create, read, update, delete) operations on books  
- **Rent & Return** – users can rent books, track due dates, and return them  
- **Stripe Payment Integration** – handle payments (e.g., overdue fees, membership costs)  
- **Responsive Frontend** – user-friendly React + TypeScript interface  
- **Secure API** – RESTful services with proper authentication and authorization  

---

## Architecture

```
 ┌───────────────┐           ┌───────────────┐
 │   React + TS   │  HTTP/   │   Spring Boot  │
 │ (Frontend SPA) │ <------> │   (Backend)    │
 └───────────────┘  REST     └───────────────┘
         |                          |
         |                          |
         |          MySQL           |
         └--------------------------┘
```
- The frontend is a **React** Single Page Application (SPA) written in **TypeScript**.  
- The backend is a **Spring Boot** application (written in **Java**), exposing a RESTful API.  
- **MySQL** is used for data persistence.  
- **Stripe** is integrated into the backend for payment processing.

---

## Tech Stack

| Layer        | Technology        |
|--------------|-------------------|
| **Frontend** | React, TypeScript, HTML, CSS  |
| **Backend**  | Java, Spring Boot, Spring Security |
| **Database** | MySQL            |
| **Payments** | Stripe API        |
| **Auth**     | Spring Security   |

