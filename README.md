# Accounts Java API

### Development Stack

- Java 8
- Spring 5
- Maven
- Swagger

### Setup guide

- install homebrew
- install JDK8, maven, eclipse/intellij (lombok processor should be initialized)
- clone or Download application code from github and unzip
- Import the project in eclipse/intellij
- Run application as "Spring Boot Application"

### Steps to run the application using cmd prompt
Below 3 ways can be used to run the application

- Go to the project directory and run "mvn spring-boot:run" cmd

- Build the project using "mvn clean install" and go to "./target" directory and run "java -jar accounts-0.0.1-SNAPSHOT.jar" cmd

- Build the application image using "docker build -t anz/accounts ." and spin up the container using "docker run -p 8080:8080 anz/accounts"

### Application APIs 
After running the application, APIs documentation can be accessed using below URLs
- http://localhost:8080/v2/api-docs
- http://localhost:8080/swagger-ui/#

### APIs examples
To support the API calls data will be loaded automatically from "accounts\src\main\resources\data.sql" into H2 database on starting the application

There are 2 APIs (mentioned below) to get the accounts and transactions data from the application
- GET /customers/{customerID}/accounts
- GET /customers/{customerID}/accounts/{accountNumber}/transactions

Below sample data can be used for the testing:
Customer Ids = 121, 122, 123
Account numbers = 1232223212, 1232223213, 1232223214, 1232223215, 1232223216.

Here are few examples to access accounts and transactions data:
curl http://localhost:8080/customers/123/accounts - will return all the accounts for customer ID - 123
curl http://localhost:8080/customers/123/accounts/1232223212/transactions - will return all the transactions for the account 1232223212 for customer ID 123

