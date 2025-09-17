# FURIA TalkSpace Backend

## Description
**FURIA TalkSpace** is a digital chat platform aimed at fans of the FURIA eSports organization's teams. The platform allows fans to communicate with each other about FURIA's different teams across various games, through chats with diverse themes.

This project was developed as part of the technical test for the **Software Engineering Assistant position at FURIA Tech**.
The chosen challenge was **Challenge #1: Conversational Experience**.

## Technologies
- **Java 21** – Programming language used in the backend.
- **Spring Boot** – Framework for building modern Java applications.
- **Spring Web** – Creation of REST APIs.
- **Spring Data JPA** – Data access and persistence using ORM.
- **Spring Security** – Management of application authentication and security.
- **Spring WebSocket** – Support for real-time bidirectional communication.
- **JWT (Auth0 Java JWT)** – Authentication based on JSON Web Tokens.
- **MySQL** – Relational database.
- **Lombok** – Reduction of boilerplate in Java classes (getters, setters, constructors, etc.).
- **Docker Compose** – Orchestration and management of containers for development environments.

## How to install and run the backend

### Prerequisites
- **Docker** installed

If you want to run it locally:
- **Java 21** installed
- **Maven** installed
- **MySQL** installed

### Execution (Docker)
1. Clone the repository and access the backend folder
    ```bash
    git clone git@github.com:PedroH225/FURIA-TalkSpace-Backend.git
    cd FURIA-TalkSpace-Backend/
    ```

2. In the same terminal, run:
    ```bash
    docker-compose up --build
    ```

### Execution (Local)
1. Clone the repository and access the backend folder
    ```bash
    git clone git@github.com:PedroH225/FURIA-TalkSpace-Backend.git
    cd FURIA-TalkSpace-Backend/
    ```

2. Change the branch
    ```bash
    git checkout -b local origin/local
    ```

3. Create the schema in mysql
    ```bash
    CREATE SCHEMA xet-da-furia-db;
    ```

4. Add the environment variable
    ```bash
    xetPass=YOUR_PASSWORD
    ```

5. Run the application
    ```bash
    ./mvnw spring-boot:run
    ```
- Or run the main file **XetDaFuriaApplication.java** through your IDE.

## Usage
- [Run the Frontend](https://github.com/PedroH225/FURIA-TalkSpace-Frontend)
- Make requests via Postman:
  [Postman File](https://github.com/PedroH225/FURIA-TalkSpace-Backend/blob/main/FURIA-TalkSpace.postman_collection.json) (Authentication is required to make requests)
