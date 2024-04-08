package com.yiu.backend.controller;

import com.yiu.backend.model.Book;
import com.yiu.backend.response.ApiResponse;
import com.yiu.backend.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public Object getAllBooks() {
        List<Book> bookList= bookService.getAllBooks();

        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("bookList",bookList);
        return  ApiResponse.success(returnData);

    }
}
