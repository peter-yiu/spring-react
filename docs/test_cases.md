# Test Case Document

**Note:** We default to using Mockito for unit testing. However, it's not recommended to include `@SpringBootTest` test cases under the `springboot` package.

This document provides details about the test cases for the project.


## 1. Backend Test Cases

### 1.1. Book Controller Test Cases

#### Test Case 1: Get All Books
- Description: Verifies that the controller returns a list of all books.
- Steps:
    1. Send a GET request to `/api/books`.
    2. Verify that the response status code is 1.
    3. Verify that the response body contains a ApiResponse Object with book objects.
- Expected Result: The controller returns a ApiResponse Object.

#### Test Case 2: Get Book by ID
- Description: Verifies that the controller returns details of a specific book by its ID.
- Steps:
    1. Send a GET request to `/api/books/{id}` with a valid book ID.
    2. Verify that the response status code is 1.
    3. Verify that the response body contains a ApiResponse Object representing the book.
- Expected Result: The controller returns details of the specified book.

#### Test Case 3: Add Book
- Description: Verifies that the controller creates a new book.
- Steps:
    1. Send a POST request to `/api/books` with valid book data in the request body.
    2. Verify that the response status code is 1.
    3. Verify that the response body contains a ApiResponse object representing the newly created book.
- Expected Result: The controller creates a new book.

#### Test Case 4: Update Book
- Description: Verifies that the controller updates details of a specific book by its ID.
- Steps:
    1. Send a PUT request to `/api/books/{id}` with a valid book ID and updated book data in the request body.
    2. Verify that the response status code is 1.
    3. Verify that the response body contains a ApiResponse object representing the updated book.
- Expected Result: The controller updates the specified book.

#### Test Case 5: Delete Book
- Description: Verifies that the controller deletes a specific book by its ID.
- Steps:
    1. Send a DELETE request to `/api/books/{id}` with a valid book ID.
    2. Verify that the response status code is 0 (No Content).
    3. Send a GET request to `/api/books/{id}` to verify that the book has been deleted.
- Expected Result: The controller deletes the specified book.

### 1.2. Book Service Test Cases

#### Test Case 1: Get All Books
- Description: Verifies that the service returns a list of all books.
- Steps:
    1. Call the `getAllBooks` method.
    2. Verify that the returned list is not empty.
- Expected Result: The service returns ApiResponse Object with a list of all books.

#### Test Case 2: Get Book by ID
- Description: Verifies that the service returns details of a specific book by its ID.
- Steps:
    1. Call the `getBookById` method with a valid book ID.
    2. Verify that the returned book object is not null.
- Expected Result: The service returns details of the specified book.

#### Test Case 3: Add Book
- Description: Verifies that the service creates a new book.
- Steps:
    1. Call the `addBook` method with valid book data.
    2. Verify that the returned book object is not null.
- Expected Result: The service creates a new book.

#### Test Case 4: Update Book
- Description: Verifies that the service updates details of a specific book by its ID.
- Steps:
    1. Call the `updateBook` method with a valid book ID and updated book data.
    2. Verify that the returned book object contains the updated data.
- Expected Result: The service updates the specified book.

#### Test Case 5: Delete Book
- Description: Verifies that the service deletes a specific book by its ID.
- Steps:
    1. Call the `deleteBook` method with a valid book ID.
    2. Verify that the book is no longer present in the database.
- Expected Result: The service deletes the specified book.

## 2. Frontend Test Cases

### 2.1. Book List Page Test Cases

#### Test Case 1: Load Book List
- Description: Verifies that the book list page loads successfully.
- Steps:
    1. Navigate to the book list page.
    2. Verify that the list of books is displayed.
- Expected Result: The book list page loads successfully.

#### Test Case 2: Filter Books by Genre
- Description: Verifies that books can be filtered by genre.
- Steps:
    1. Select a genre from the filter dropdown.
    2. Verify that only books with the selected genre are displayed.
- Expected Result:
