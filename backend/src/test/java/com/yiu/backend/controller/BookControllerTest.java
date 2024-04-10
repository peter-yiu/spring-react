package com.yiu.backend.controller;

import com.yiu.backend.model.Book;
import com.yiu.backend.response.ApiResponse;
import com.yiu.backend.response.ApiResponseCode;
import com.yiu.backend.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // 准备数据
        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Book 1");
        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Book 2");
        List<Book> books = Arrays.asList(book1, book2);
        when(bookService.getAllBooks()).thenReturn(books);

        // 调用被测试的方法
        ApiResponse response = bookController.getAllBooks();

        // 验证返回的 ResponseEntity 是否正确
        assertNotNull(response);
        assertEquals(ApiResponseCode.SUCCESS.getCode(), response.getCode());
        assertEquals(2, ((Map<String,List<Book>>)response.getData()).get("bookList").size());
        assertEquals("Book 1", ((Map<String,List<Book>>)response.getData()).get("bookList").get(0).getTitle());
        assertEquals("Book 2", ((Map<String,List<Book>>)response.getData()).get("bookList").get(1).getTitle());
    }

    @Test
    public void testGetBookById() {
        // 准备数据
        Book book = new Book();
        book.setId(1);
        book.setTitle("Test Book");
        when(bookService.getBookById(1)).thenReturn(book);

        // 调用被测试的方法
        ApiResponse response  = bookController.getBookById(1);

        // 验证返回的 ResponseEntity 是否正确
        assertNotNull(response);
        assertEquals(ApiResponseCode.SUCCESS.getCode(), response.getCode());
        assertEquals("Test Book", ((Map<String,Book>)response.getData()).get("book").getTitle());
    }

    @Test
    public void testGetBookByIdNotFound() {
        // 设置模拟行为
        when(bookService.getBookById(1)).thenReturn(null);

        // 调用被测试的方法
        ApiResponse response = bookController.getBookById(1);

        // 验证返回的 ResponseEntity 是否正确
        assertNotNull(response);
        assertEquals(ApiResponseCode.FAILED.getCode(), response.getCode());
    }

}
