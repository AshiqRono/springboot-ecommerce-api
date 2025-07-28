## E-Commerce API

A Spring Boot 3.2.2 REST API project for managing customers, products, orders, wishlists, and sales history.
This project uses PostgreSQL, Liquibase, Docker, and Swagger for API documentation.

#### REST API with Spring Boot 3.2.2 
#### PostgreSQL 17 + Liquibase migrations
#### Docker & Docker Compose setup
#### Logging with Logback (console + file)
#### Swagger UI for API documentation


### Build & run WITH Docker

#### docker compose up --build
#### Swagger will be available here:http://localhost:8088/swagger-ui.html
#### PostgreSQL will be available: localhost:5433

The ports are mapped as follows(host:container) :
#### 8088:8080
#### 5433:5432


### Build & run WITHOUT Docker

#### mvn clean package -DskipTests
#### java -jar target/ecommerce-api.jar
#### Swagger will be available here:http://localhost:8080/swagger-ui.html
#### PostgreSQL will run: localhost:5432

### APIs exposed
#### /api/customer/wishlist/{cust_id}
#### /api/product/topSelling
#### /api/product/mostSelling
#### /api/sales/totalSaleOfTheDay
#### /api/sales/maxSaleDay?start=date&end=date



