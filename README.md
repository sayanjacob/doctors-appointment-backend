# Library Microservices

For you assessment you have to develop a microservice application 
that will manage a local library.
There are four services in this microservice application.
- `authors-service`
- `books-service`
- `gateway-service`
- `discovery-service`

## Microservices details

### General Instructions

- Fork and clone this repo to complete the assessment
- Once complete push the code and provide `reporter` access to `@Ashish.s.panicker` and `mary.rani@stackroute.in`
- Use sl4j logging to log errors and failed api calls
- Use `RestTemplate` or `OpenFeign` to communicate between apis
- Use the service name specified in the documentation as the application names

### `authors-service`

Microservice that will keep track of authors whose books are in the library.  

#### Endpoints

| HTTP Method | Endpoint              | Description                    | Return value                                                                        |
|-------------|-----------------------|--------------------------------|-------------------------------------------------------------------------------------|
| POST        | /authors              | Create a new Author            | Returns the newly created author object                                             |
| GET         | /authors/{name}       | Find the author with that name | Returns the author object if an author is present otherwise returns status of `404` |
| GET         | /authors/{name}/books | Find the books by that author  | Returns the list of books authored by the author or else return `204`               |

#### Domain model

```
Author {
    id: int
    name: string
}
```

#### Instructions

- Maintain a static list of authors in a mutable collection
- Register the microservice with the `discovery-service`
- `authors-service` should be running on port `8000`
***

### `books-service`

Microservice that will keep track of books written by the authors whose details are in the library.

#### Endpoints

| Method | Endpoint          | Description                          | Return value                                                          |
|--------|-------------------|--------------------------------------|-----------------------------------------------------------------------|
| GET    | /books/{title}    | Find the book with that title        | Returns a book with that title or else return `404`                   |
| GET    | /books/s/{author} | Find the books written by the author | Returns the list of books authored by the author or else return `204` |
| POST   | /books            | Create a new book                    | Returns the created book                                              |

### Domain model

```
Book {
    id: int
    title: String
    author: String
}
```

#### Instructions

- Maintain a static list of books in a mutable collection
- Register the microservice with the `discovery-service`
- A new book can only be created if the author with exists in the `authors-service`
- `books-service` should be running on port `8100`
***

### `gateway-service`

Microservice that will provide a common entry point to all the microservices in the application.

#### Endpoints

| Method | Endpoint                      | Description                          |
|--------|-------------------------------|--------------------------------------|
| GET    | /library/books/{title}        | Find the book with that title        | 
| GET    | /library/books/{author}       | Find the books written by the author |
| POST   | /library/books                | Create a new book                    | 
| POST   | /library/authors              | Create a new Author                  |
| GET    | /library/authors/{name}       | Find the author with that name       |
| GET    | /library/authors/{name}/books | Find the bookes with that author     |


#### Instructions

- `gateway-service` should be running on port `8080`
***

### `discovery-service`

Microservice that will allow discovery of other services.

#### Instructions

- `discovery-service` should be running on port `8761`
***
