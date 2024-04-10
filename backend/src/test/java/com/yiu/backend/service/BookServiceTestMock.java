package com.yiu.backend.service;

import com.yiu.backend.model.Book;
import com.yiu.backend.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

public class BookServiceTestMock {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    public BookServiceTestMock() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    void testAddBook() {
        // 准备数据
        Book bookToSave = new Book();
        bookToSave.setTitle("Test Book");

        // 调用被测试的方法
        bookService.addBook(bookToSave);

        // 验证是否正确调用了保存方法
        verify(bookRepository, times(1)).save(bookToSave);
    }

    @Test
    void testBookById() {
        // 设置模拟行为
        Book mockBook = new Book();
        mockBook.setId(1);
        mockBook.setTitle("Test Book");
        when(bookRepository.findById(1)).thenReturn(Optional.of(mockBook));

        // 调用被测试的方法
        Book result = bookService.getBookById(1);

        // 断言
        assertNotNull(result);
        assertEquals("Test Book", result.getTitle());
    }
    @Test
    public void testGetBookByIdNotFound() {
        // 设置模拟行为
        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        // 调用被测试的方法
        Book result = bookService.getBookById(1);

        // 断言
        assertNull(result);
    }
    @Test
    void testUpdateBook() {

        // 准备数据
        Book existingBook = new Book();
        existingBook.setId(1);
        existingBook.setTitle("Existing Book");

        Book updatedBook = new Book();
        updatedBook.setId(1);
        updatedBook.setTitle("Updated Book");

        // 设置模拟行为
        when(bookRepository.findById(1)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        // 调用被测试的方法
        Book result = bookService.updateBook(1, updatedBook);

        // 验证是否正确调用了 findById 和 save 方法
        verify(bookRepository, times(1)).findById(1);
        verify(bookRepository, times(1)).save(any(Book.class));

        // 断言
        assertNotNull(result);
        assertEquals("Updated Book", result.getTitle());


    }

    @Test
    public void testUpdateBookNotFound() {
        // 准备数据
        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        Book updatedBook = new Book();
        updatedBook.setId(1);
        updatedBook.setTitle("Updated Book");

        // 调用被测试的方法并断言
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.updateBook(1, updatedBook);
        });
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
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // 调用被测试的方法
        List<Book> result = bookService.getAllBooks();

        // 断言
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Book 2", result.get(1).getTitle());
    }

    @Test
    public void testGetAllBooksByPage() {
        // 准备数据
        int pageNo = 1;
        int pageSize = 10;
        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Book 1");
        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Book 2");
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("id")));

        Page<Book> books=new PageImpl<>(Arrays.asList(book1, book2));

        when(bookRepository.findAll(pageable)).thenReturn(books);

        // 调用被测试的方法
        List<Book> result = bookService.getAllBooksByPage(pageable).getContent();

        // 断言
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Book 2", result.get(1).getTitle());
    }

    @Test
    public void testFindAllByTitle() {
        // 准备数据
        String title = "Book";
        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Book 1");
        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Book 2");
        when(bookRepository.findAllByTitleContaining(title)).thenReturn(Arrays.asList(book1, book2));

        // 调用被测试的方法
        List<Book> result = bookService.findAllByTitle(title);

        // 断言
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
        assertEquals("Book 2", result.get(1).getTitle());
    }
    @Test
    public void testDeleteBook() {
        // 调用被测试的方法
        bookService.deleteBook(1);

        // 验证是否正确调用了删除方法
        verify(bookRepository, times(1)).deleteById(1);
    }
}
