Library App
A full-stack application that allows users to register, rent, and return books. Built with React + TypeScript on the frontend and Java + Spring Boot on the backend, with MySQL as the database. Authentication and authorization are handled via Spring Security, and payments are processed through Stripe.
________________________________________
Table of Contents
•	Features
•	Tech Stack
•	Prerequisites
________________________________________
Features
•	User Registration & Login: Managed by Spring Security
•	Role-based Authorization: Three roles — USER, MODERATOR, and ADMIN
•	Book Inventory: Create, read, update, and delete (CRUD) operations for books
•	Rent & Return: Users can rent books, keep track of due dates, and return them
•	Payment Integration (Stripe): Payments for overdue books, membership fees, etc.
•	Responsive Frontend: Built with React + TypeScript
•	Secure RESTful API: Spring Boot handles database operations and authentication
________________________________________
Tech Stack
•	Frontend
o	React
o	TypeScript
•	Backend
o	Java
o	Spring Boot
o	Spring Security
•	Database
o	MySQL
•	Payments
o	Stripe API
________________________________________
Prerequisites
•	Node.js (v14+ recommended) and npm or yarn
•	Java (JDK 11 or higher)
•	Maven (for building the Spring Boot backend)
•	MySQL database running locally or accessible via network
•	Stripe account (for payment integration)
________________________________________
