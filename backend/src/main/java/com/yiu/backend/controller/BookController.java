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
    public Object addBook(@RequestBody Book book) {
        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("book",bookService.addBook(book));
        return  ApiResponse.success(returnData);
    }

    @GetMapping("/{id}")
    public Object getBookById(@PathVariable Integer id) {


        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("book",bookService.getBookById(id));
        return  ApiResponse.success(returnData);
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable Integer id, @RequestBody Book book) {

         book= bookService.updateBook(id, book);

        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("book",book);
        return  ApiResponse.success(returnData);
    }

    @DeleteMapping("/{id}")
    public Object deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ApiResponse.success();
    }

    @GetMapping
    public Object getAllBooks() {
        List<Book> bookList= bookService.getAllBooks();

        Map<String,Object> returnData=new LinkedHashMap<String, Object>();
        returnData.put("bookList",bookList);
        return  ApiResponse.success(returnData);

    }
}
