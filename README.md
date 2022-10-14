**Table of Contents**
- [Intro](#Crud-wit-Spring-Boot,-GraphQL-and-H2)
- [Getting Started](#Getting-Started)
- [How to use](#How-to-Use)
- [EndPoints]()


# Crud with Spring Boot, GraphQL and H2
This is a simple proyect as the intro is a Crud of two tables (User, Tickets) made with [GraphQL](https://github.com/graphql/graphiql)

# Getting Started
This proyect uses [Java Faker](https://github.com/DiUS/java-faker) to create test data. This configuration is found in the package `data` if you present problem you can read the documentation.

Well to get started your java version must be 17 or higher.

# How to Use

### Configuration H2
If you want to go check the database:
```
/h2-console
```
everthing is already configured for you to go simply connect but if you want you can also change the settings.

----------

### Configuration GraphQL
You can test the application through:
```
/graphiql?path=/graphql
```
Also you can utilization `@EnableGraphQLServer` annotation that is set at the main java configuration class to change the current accessibility

# Endpoint

### Create
Add datas in User and Ticket
````graphql
mutation {
    createUser(firstName: "Juan", lastName: "Tique"){
        id
        firstName
        lastName
    }
    
    createTicket(user_id: 1, status: FALSE){
        id
        createdDate
        updatedDate
        status {
            estado
        }
        userPerson {
            id
            firstName
            lastName
        }
    }
}
````

### Update
Example of how update datas
````graphql
mutation {
    updateTicket(status: FALSE, id: 1, user_id: 1){
        status {
            estado
        }
        updatedDate
        createdDate
        userPerson {
            firstName
        }
    }
    
    updateUser(id: 1, firstName: "Antonio", lastName: "Ramirez"){
        id
        firstName 
        lastName
    }
}
````

### Delete
For delete information
```graphql
mutation {
    deleteTicket(id: 2){
        id
        status {
            estado
        }
    }
    
    deleteUser(id: 1){
        status
        lastName
    }
}
```

### Query
````graphql
query {
    allTickets {
        id 
        createdDate
        userPerson {
            id
            firstName
        }
        status {
            estado
        }
        updatedDate
    }
    
    allUsers {
        id
        firstName
        lastName
    }
}
````

### Pagination
````graphql
query {
    allTicketPaged(page: 0, size: 2){
        id
        createdDate
        userPerson {
            id
            firstName
        }
        status {
            estado
        }
        updatedDate
    }
    
    allUserPersonPaged(page: 0, size: 2){
        id
    }
}
````

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#data.sql.jdbc)
* [Validation](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#io.validation)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web.security)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

