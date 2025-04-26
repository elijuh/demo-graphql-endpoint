# Demo GraphQL Endpoint
This project demonstrates a basic GraphQL API built with Spring Boot, providing CRUD operations through a simple GraphQL schema.

## Features
Spring Boot backend

GraphQL integration

Basic CRUD operations

Maven build setup

## Getting Started
To run the project:
```
./mvnw spring-boot:run
```
Access the GraphiQL Web Interface at: `http://localhost:8080/graphiql`

## Requirements
Java 17+

Maven 3.8+

## GraphQL Endpoints

### Queries
- **`authors`**:  
  Retrieve a list of all authors.

- **`authorById(id: ID!)`**:  
  Fetch a single author by their unique ID.

- **`books`**:  
  Retrieve a list of all books.

### Mutations
- **`addBook(bookInput: BookInput!)`**:  
  Add a new book with details like title, publisher, page count, and associated author.

- **`addAuthor(authorInput: AuthorInput!)`**:  
  Create a new author with a given name.

- **`reassignAuthor(bookId: ID!, authorId: ID!)`**:  
  Change the author of an existing book to a different author by providing their IDs.


## License
This project is licensed under the MIT License.
