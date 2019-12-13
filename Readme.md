# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple Producto application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://172.16.90.98:8080/gitblit162/r/spring-boot-mysql.git
```

**2. Create Mysql database**
```bash
create database demo
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn spring-boot:run
```
Alternatively, you can run the app without packaging it using -
```bash
mvn package
java -jar target/demo-1.0.0.jar
```


The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/productos

    POST /api/productos

    GET /api/productos/{productoId}

    PUT /api/productos/{productoId}

    DELETE /api/productos/{productoId}

You can test them using postman or any other rest client.

## Learn more

You can find the alternative tutorial based for this application on:

<https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
