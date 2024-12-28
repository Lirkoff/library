# Library App

[![Java](https://img.shields.io/badge/Java-11%2B-blue.svg)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7%2B-brightgreen.svg)](https://spring.io/projects/spring-boot)  
[![React](https://img.shields.io/badge/React-18%2B-61DAFB.svg)](https://reactjs.org/)  
[![TypeScript](https://img.shields.io/badge/TypeScript-4.5%2B-blue.svg)](https://www.typescriptlang.org/)  
[![MySQL](https://img.shields.io/badge/MySQL-8%2B-blue.svg)](https://www.mysql.com/)  
[![Stripe](https://img.shields.io/badge/Stripe-API-008cdd.svg)](https://stripe.com/)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A **full-stack library application** that allows users to register, **rent**, **renew**, and **return** books. The solution consists of a **React + TypeScript** frontend, a **Java + Spring Boot** backend, and a **MySQL** database. **Spring Security** (with JWT) ensures secure authentication and authorization. The application integrates **Stripe** for handling payment processing (e.g., late fees), and relies on **self-signed HTTPS** certificates for enhanced security.

---

## Table of Contents

1. [Features](#features)  
2. [Screenshots](#screenshots)  
3. [Architecture](#architecture)  
4. [Tech Stack](#tech-stack)  
5. [Installation & Setup](#installation--setup)  
6. [Usage](#usage)  
7. [Contributing](#contributing)  
8. [License](#license)  

---

## Features

- **User Registration & Login**  
  - Secure sign-up and sign-in flow using **Spring Security** and **JWT** tokens.
  - Role-based authorization with three main roles: **USER**, **MODERATOR**, and **ADMIN**.

- **Book Management**  
  - **CRUD** operations for books, with admin privileges to add new titles or modify existing ones.  
  - View available/total copies for each book.

- **Rent, Return, & Renew**  
  - Users can **rent** books, see due dates, and **return** or **renew** them within the **Shelf/Loans** menu.  
  - If a book is overdue (>7 days), the user cannot rent another book until fees are paid.  
  - **Stripe** integration for handling fees or membership payments.

- **Ratings & Reviews**  
  - Users can rate books from 0 to 5 stars.  
  - Logged-in users can leave reviews. Ratings and review statistics are displayed on each book’s page.

- **Search & Categories**  
  - A powerful search page that lets users find books by keyword.  
  - Sorting by category, rating, or other filters.

- **Messaging System**  
  - Users can send messages/requests to administrators (e.g., report issues or ask questions).  
  - Admins can reply to users’ messages in an **Admin Panel**.

- **Self-Signed HTTPS Certificates**  
  - Both frontend and backend run over HTTPS using self-signed certificates for secure communication.

---

## Screenshots


### 1. Home Page

![home 1](https://github.com/user-attachments/assets/4354c3ba-e01a-426c-a22e-a377099b69b7)
![home 2](https://github.com/user-attachments/assets/df7c4823-33f6-4f42-b2ce-bf42196d832b)


### 2. Search Books

![search books](https://github.com/user-attachments/assets/8a255cfa-2cb7-456d-98ac-84820d7f82a1)


### 3. Book Details & Reviews

![book details](https://github.com/user-attachments/assets/c909814a-e815-48c6-99f2-68cd6f83d3ba)


### 4. Admin Panel

![admin menu](https://github.com/user-attachments/assets/04914610-089d-4e2a-8e4e-f8944b35a1b5)


### 5. Fees & Payments

![fees](https://github.com/user-attachments/assets/27e6cba9-7f15-4620-af27-ab07a069aa81)


---

## Architecture

```
 ┌────────────────┐          ┌────────────────────────┐
 │ React + TS     │  HTTPS   │ Spring Boot + Security │
 │ (Frontend SPA) │ <------> │ (Backend + REST API)   │
 └────────────────┘          └────────────────────────┘
         |                           |
         |                           |
         |          MySQL            |
         └---------------------------┘
```

1. **Frontend**  
   - Built with **React** (SPA) and **TypeScript**.  
   - Communicates with the backend via REST endpoints over HTTPS.

2. **Backend**  
   - **Spring Boot** + **Spring Security** (JWT) for secure and robust HTTP-based services.  
   - Exposes RESTful APIs, handles payments with **Stripe**, and enforces role-based access control.

3. **Database**  
   - **MySQL** manages user profiles, book records, transactions, messages, and other persistent data.

---

## Tech Stack

| Layer           | Technology                                      |
|-----------------|-------------------------------------------------|
| **Frontend**    | React, TypeScript, HTML, CSS                    |
| **Backend**     | Java 11+, Spring Boot, Spring Security (JWT)    |
| **Database**    | MySQL 8+                                        |
| **Payments**    | Stripe API                                      |
| **Auth**        | Spring Security + JWT                           |
| **Hosting**     | Self-signed HTTPS Certificates (dev/production) |

---

## Installation & Setup

Below are high-level steps for local development. Adjust to your needs if you have a particular CI/CD pipeline or deployment environment.

### Prerequisites

- **Java 11+** installed.  
- **Node.js** (v14+) and **npm** or **Yarn** for frontend.  
- **MySQL** 8+ running locally or a remote MySQL instance.  
- A **Stripe** account (and API keys) for payment integration.  
- (Optional) Self-signed certificates for HTTPS configuration.

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/<library-app>.git
cd library-app
```

### 2. Configure the Backend

1. Open the `application.properties` (or `application.yml`) in the backend directory.  
2. Provide your MySQL connection details:
   ```properties
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC
   spring.datasource.username=<db_user>
   spring.datasource.password=<db_password>
  

   # Stripe integration
   stripe.key.secret=<your_stripe_api_key>
   ```

### 3. Configure the Frontend

1. Navigate to the frontend directory (e.g., `cd frontend`).  
2. In the `.env` file where the environment variables are stored, add your React Stripe key:
   ```
   REACT_APP_STRIPE_KEY=<your_react_stripe_api_key>
   ```
3. Install dependencies:
   ```bash
   npm install
   ```
   or
   ```bash
   yarn install
   ```

### 4. Build & Run

#### Backend
```bash
# From the backend directory
./mvnw spring-boot:run
```
_(Or use your preferred IDE to run the Spring Boot application.)_

#### Frontend
```bash
# From the frontend directory
npm start
```
_(Or `yarn start` if you use Yarn.)_

After successful startup, you should be able to access the application at:
```
Frontend (HTTPS): https://localhost:3000
Backend (HTTPS) : https://localhost:8443
```

---

## Usage

1. **Register a New Account**:  
   - Go to the registration page.  
   - Fill in your details. Your account will start with **USER** permissions by default.

2. **Log In**:  
   - Use your credentials to log in.  
   - A JWT token is returned and stored locally to authorize future requests.

3. **Browse & Search Books**:  
   - On the **Search** page, type a keyword or select a category to filter books.  
   - Check each book’s availability, rating, and total copies.

4. **Rent, Return, or Renew**:  
   - Under **Shelf/Loans**, you will see which books you have currently loaned.  
   - **Return** or **Renew** any book if it’s nearing its 7-day limit.  
   - Overdue books will incur fees, payable via **Stripe**.

5. **Leave a Review**:  
   - Rate the book (1–5 stars) and optionally leave a textual review once you have loaned the book.

6. **Admin Panel** (ADMIN Role Required):  
   - **Add new books**, change quantities, manage user messages.  
   - Reply to messages from users within the panel.

7. **Paying Fees**:  
   - Overdue fees or membership costs can be paid by navigating to the **Fees** menu, which uses **Stripe** for secure payment.

---

## Contributing

Contributions are welcome! To propose changes:

1. **Fork** the repository.  
2. Create a new **feature branch**.  
3. **Commit** your changes with descriptive messages.  
4. Open a **pull request** against the main branch.

We encourage developers to write clean, testable code and follow general best practices for both React/TypeScript and Java/Spring Boot.

---

## License

This project is licensed under the terms of the [MIT License](LICENSE). Feel free to modify and use this project in your own applications, subject to the terms of the license.

---

**Thank you for checking out the Library App!**  
If you have any questions or suggestions, please feel free to open an issue or submit a pull request. Enjoy reading!
