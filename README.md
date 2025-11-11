# S04.T02 - API REST WITH SPRINGBOOT

---
  
# 🎯 Objectives

The main objective of these exercises is to master CRUD operations and database integration in Spring Boot applications. Specifically, the goals are:

1. **CRUD Operations Mastery**: Implement complete Create, Read, Update, Delete functionality following REST principles and best practices.

2. **Multi-Database Integration**: Gain practical experience working with three different database systems:
   - H2 (in-memory database)
   - MySQL (relational database)
   - MongoDB (NoSQL document database)

3. **HTTP Protocol Excellence**: Learn to properly use HTTP verbs and manage response codes:
   - Correct verb mapping (GET, POST, PUT, DELETE)
   - Appropriate status codes (200, 201, 404, 500, etc.)
   - ResponseEntity usage for proper API responses

4. **MVC Architecture Implementation**: Develop skills in structuring applications following Model-View-Controller pattern with proper package organization.

5. **Error Handling & Resilience**: Implement robust error handling through:
   - GlobalExceptionHandler for centralized exception management
   - Proper exception propagation
   - Consistent error responses across the application

6. **API Best Practices**: Learn industry standards for:
   - RESTful endpoint design
   - Request/response handling
   - Data persistence strategies

---

# 📝 Exercises to Perform

## Level 1 - CRUD with H2 Database

### Exercise 1 - H2 In-Memory Database Implementation:

Create a Spring Boot application with CRUD operations using H2 database.

1. **Generate Spring Boot Project** at https://start.spring.io/ with:
   - **Project**: Maven or Gradle
   - **Language**: Java
   - **Spring Boot**: Latest stable version
   - **Project Metadata**:
     - Group: `cat.itacademy.s04.t02.n01`
     - Artifact: `S04T02N01`
     - Name: `S04T02N01`
     - Description: `S04T02N01GognomsNom`
     - Package name: `cat.itacademy.s04.t02.n01`
   - **Packaging**: Jar
   - **Java**: Minimum version 11
   - **Dependencies**:
     - Spring Boot DevTools
     - Spring Web
     - Spring Data JPA
     - H2 Database

2. **Entity Definition**:
   Create "Fruita" (Fruit) entity with properties:
   - `int id` - Primary key
   - `String nom` - Fruit name
   - `int quantitatQuilos` - Quantity in kilograms

3. **Package Structure** (following MVC pattern):
   ```
   cat.itacademy.s04.t02.n01.controllers
   cat.itacademy.s04.t02.n01.model
   cat.itacademy.s04.t02.n01.services
   cat.itacademy.s04.t02.n01.repository
   cat.itacademy.s04.t02.n01.exception
   ```

4. **REST Endpoints** (FruitaController):
   - **POST** `http://localhost:8080/fruita/add` - Create new fruit
   - **PUT** `http://localhost:8080/fruita/update` - Update existing fruit
   - **DELETE** `http://localhost:8080/fruita/delete/{id}` - Delete fruit by ID
   - **GET** `http://localhost:8080/fruita/getOne/{id}` - Get single fruit by ID
   - **GET** `http://localhost:8080/fruita/getAll` - Get all fruits

5. **Requirements**:
   - Implement proper HTTP status codes
   - Use ResponseEntity for responses
   - Create GlobalExceptionHandler for centralized error handling
   - Follow REST API best practices

---

## Level 2 - CRUD with MySQL

### Exercise 1 - MySQL Database Implementation:

Replicate Level 1 functionality using MySQL as the persistence layer.

1. **Generate Spring Boot Project** at https://start.spring.io/ with:
   - **Project**: Maven or Gradle
   - **Language**: Java
   - **Spring Boot**: Latest stable version
   - **Project Metadata**:
     - Group: `cat.itacademy.s04.t02.n02`
     - Artifact: `S04T02N02`
     - Name: `S04T02N02`
     - Description: `S04T02N02`
     - Package name: `cat.itacademy.s04.t02.n02`
   - **Packaging**: Jar
   - **Java**: Minimum version 11
   - **Dependencies**:
     - Spring Boot DevTools
     - Spring Web
     - Spring Data JPA
     - MySQL Driver

2. **Database Configuration**:
   - Configure MySQL connection in `application.properties`
   - Create database schema
   - Set up JPA/Hibernate properties

3. **Implementation**:
   - Same entity structure as Level 1
   - Same package organization
   - Same REST endpoints
   - Persist data to MySQL database

---

## Level 3 - CRUD with MongoDB

### Exercise 1 - MongoDB NoSQL Implementation:

Implement CRUD operations using MongoDB as the document database.

1. **Generate Spring Boot Project** at https://start.spring.io/ with:
   - **Project**: Maven or Gradle
   - **Language**: Java
   - **Spring Boot**: Latest stable version
   - **Project Metadata**:
     - Group: `cat.itacademy.s04.t02.n03`
     - Artifact: `S04T02N03`
     - Name: `S04T02N03`
     - Description: `S04T02N03`
     - Package name: `cat.itacademy.s04.t02.n03`
   - **Packaging**: Jar
   - **Java**: Minimum version 11
   - **Dependencies**:
     - Spring Boot DevTools
     - Spring Web
     - Spring Data MongoDB

2. **MongoDB Configuration**:
   - Configure MongoDB connection
   - Set up document collections
   - Adapt entity for document storage

3. **Implementation**:
   - Adapt entity as MongoDB document
   - Same package organization
   - Same REST endpoints
   - Persist data to MongoDB

---

# 💻 Technologies Used  

- **Java 11+** → Programming language
- **Spring Boot** → Framework for building REST APIs
- **Spring Data JPA** → Data persistence abstraction (Level 1 & 2)
- **H2 Database** → In-memory database (Level 1)
- **MySQL** → Relational database (Level 2)
- **Maven/Gradle** → Dependency management
- **Spring Web** → REST controller support
- **Postman** → API testing
- **Git** → Version control

---

## 📋 Requirements  

### General Requirements:
- Java 11 or higher
- Maven 3.6+ or Gradle 6.0+
- IDE (IntelliJ IDEA)
- Postman for API testing
- Git

### Database-Specific Requirements:

**Level 1 (H2):**
- No additional installation (embedded database)

**Level 2 (MySQL):**
- MySQL Server 8.0+
- MySQL Workbench (optional)

**Level 3 (MongoDB):**
- MongoDB Server 4.4+
- MongoDB Compass (optional)

---

## 🛠️ Setup

###**Clone the repository**: https://github.com/polserrano8/4.2-ApiRest-with-SpringBoot
   ```bash
   git clone 
   ```

### Level 1 - H2 Setup:

```bash
cd S04T02N01
mvn clean install
mvn spring-boot:run
# H2 Console: http://localhost:8080/h2-console
```

### Level 2 - MySQL Setup:
```bash
# Start MySQL service
mysql -u root -p

# Create database
CREATE DATABASE fruita_db;

# Configure application.properties
cd S04T02N02
mvn clean install
mvn spring-boot:run
```

### Level 3 - MongoDB Setup:
```bash
# Start MongoDB service
mongod

# Configure application.properties
cd S04T02N03
mvn clean install
mvn spring-boot:run
``

---

## 📚 Learning Resources

### Spring Data & JPA
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [JPA Entity Relationships](https://www.baeldung.com/jpa-entities)
- [ResponseEntity Guide](https://www.baeldung.com/spring-response-entity)

### Database Specific
- [H2 Database Features](https://www.h2database.com/html/features.html)
- [MySQL with Spring Boot](https://spring.io/guides/gs/accessing-data-mysql/)
- [MongoDB with Spring Boot](https://spring.io/guides/gs/accessing-data-mongodb/)

### Exception Handling
- [Spring Boot Exception Handling](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [Global Exception Handler](https://www.baeldung.com/global-error-handler-in-a-spring-rest-api)

### REST Best Practices
- [REST API Design Best Practices](https://restfulapi.net/resource-naming/)
- [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)

---

## 🔗 Contributions

The project ignores:
- `.idea/`
- `.gradle/`
- `target/`
- `build/`
- `*.iml`
- `.classpath`
- `.project`
- `.settings/`

To contribute:
1. Fork the repository
2. Create feature branch: `git checkout -b feature/NewFeature`
3. Commit changes: `git commit -m 'Add CRUD feature'`
4. Push to branch: `git push origin feature/NewFeature`
5. Open Pull Request

---

## 📝 Important Notes

- **Database Persistence**: H2 data is lost on restart (in-memory), MySQL and MongoDB persist data
- **Port Conflicts**: Ensure database ports are available (MySQL: 3306, MongoDB: 27017)
