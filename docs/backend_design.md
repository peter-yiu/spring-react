# Backend Design

## 1. Project Structure

### Project Structure

```
src/
|-- main/
|   |-- java/
|       |-- com/
|       |-- yiu/
|       |-- backend/
|           |-- controller/
|               |-- BookController.java
|           |-- model/
|               |-- Book.java
|           |-- repository/
|               |-- BookRepository.java
|           |-- service/
|               |-- BookService.java
|       |-- BackendApplication.java
|-------resources/
|       |-- application.properties
```



## 2. Module Design

### Module Functions
- `controller`: Controller layer responsible for receiving requests from the frontend and invoking corresponding service layer methods to handle requests.
- `model`: Entity layer defining the entities used in the project, such as the Book entity.
- `repository`: Data access layer defining JPA Repository interfaces for database operations.
- `service`: Service layer containing business logic, implementing specific business functions invoked by the controller layer.
- `BackendApplication`: Spring Boot application's startup class.

## 3. API Design

### API List
- `GET /api/books`: Get all books.
- `GET /api/books/{id}`: Get book details by ID.
- `POST /api/books`: Create a new book.
- `PUT /api/books/{id}`: Update book details.
- `DELETE /api/books/{id}`: Delete a book.

### API Details
- `GET /api/books`:
    - Method: GET
    - Request Parameters: None
    - Response: ApiResponse Object with book objects
      - Example Response:
        ```json
        {
         "code":1,
         "msg": "success",
         "data":{
                 "bookList": [
                         {
                           "id": 1,
                           "title": "Book 1",
                           "author": "Author 1",
                           "publication_date": "2022-04-20",
                           "description": "Description of Book 1"
                         },
                         {
                           "id": 2,
                           "title": "Book 2",
                           "author": "Author 2",
                           "publication_date": "2022-05-15",
                           "description": "Description of Book 2"
                         }
                       ]
                }
        }

        ```

    - Other APIs are similar, with specific parameters and responses defined based on actual requirements.

## 4. Key Code Explanation

### BookController.java
```java
// Other code omitted...
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ApiResponse getAllBooks() {
        List<Book> bookList= bookService.getAllBooks();

        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("bookList",bookList);
        return  ApiResponse.success(returnData);
    }

    @GetMapping("/{id}")
    public ApiResponse getBookById(@PathVariable Long id) {
        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        Book book=bookService.getBookById(id);
        if(book != null){
            returnData.put("book",book);
            return  ApiResponse.success(returnData);
        }else{
            return ApiResponse.failMessage("Not Found Id:"+id.toString());
        }
    }

    // Other methods omitted...
}


@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Other methods omitted...
}


public interface BookRepository extends JpaRepository<Book, Long> {
}



```

