# Lab Management System - Backend

The Lab Management System backend is powered by Spring Boot, providing a robust and scalable Java-based application for managing lab resources, projects, and finances.

## Features

- **Member Management**: Maintain lab members' details, allocations, and funding sources.
- **Resource Allocation**: Allocate resources to members from research projects or Uc@Rech - scientific production endowments.
- **Project Management**: Create and manage research projects with budget allocation and associated members.
- **Financial Tracking**: Monitor and track financial transactions, expenses, and funding sources.
- **Reporting**: Generate reports on resource allocation, project progress, and financial summaries.

## Installation and Setup

1. Clone the repository: `git clone <backend-repo-url>`
2. Navigate to the project directory: `cd lab-management-backend`
3. Configure database settings in `application.properties` file.
4. Build and run the application: `mvn spring-boot:run`

Ensure to replace `<frontend-repo-url>` and `<backend-repo-url>` with the actual URLs of your frontend and backend repositories.

## Technologies Used

- **Spring Boot**: Backend framework for building robust and scalable Java-based applications.
- **JWT (JSON Web Tokens)**: Security mechanism for authentication and authorization.
- **Database**: Utilize a database system (e.g., MySQL, PostgreSQL) for secure data storage.
