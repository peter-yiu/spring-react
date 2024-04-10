# Database Design

The database design for the project is based on the requirements of managing books. It consists of a single table to store book information.

## 1. Entity-Relationship Diagram (ERD)

The ERD for the database consists of a single entity:

[Book]

    id (Primary Key)
    title
    isbn
    author
    genre
    publication_date
    description
    file_path




## 2. Table Structure

### 2.1. Book Table

The `Book` table stores information about books in the application.

| Field             | Type         | Description                            |
|-------------------|--------------|----------------------------------------|
| id                | INT          | Primary Key, Auto-increment            |
| title             | VARCHAR(255) | Title of the book                      |
| author            | VARCHAR(255) | Author of the book                     |
| isbn              | VARCHAR(20)  | ISBN (International Standard Book Number) of the book |
| genre             | VARCHAR(100) | Genre of the book                      |
| publication_date  | DATE         | Publication date of the book           |
| description       | TEXT         | Description or summary of the book     |
| file_path         | VARCHAR(255) | Path to the book file                  |

## 3. Relationships

There are no explicit relationships defined in the database design as it consists of a single table. However, the `id` field serves as the primary key for the `Book` table, allowing for unique identification of each book record.

## 4. Indexes

No indexes are explicitly defined in the database design. However, the primary key (`id`) field is automatically indexed by most database systems to ensure efficient retrieval of records.

## 5. Normalization

The database design adheres to the principles of normalization, with each column storing atomic values and avoiding redundancy.

