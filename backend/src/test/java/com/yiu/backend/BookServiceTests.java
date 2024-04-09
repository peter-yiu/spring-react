package com.yiu.backend;


import com.yiu.backend.model.Book;
import com.yiu.backend.service.BookService;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
public class BookServiceTests {

    private static final Logger log = LoggerFactory.getLogger(BookServiceTests.class);

    @Autowired
    private BookService bookService;




    @Test
    public void testJpa() throws Exception {
        final Book book = bookService.addBook(new Book("book1", "auther one", "0011"));
        log.info("[添加成功] - [{}]", book);
        final List<Book> bookList = bookService.findAllByTitle("book1");
        Assumptions.assumeTrue(bookList.size() > 0);

        log.info("[条件查询] - [{}]", bookList);
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.asc("id")));
        final Page<Book> books = bookService.getAllBooksByPage(pageable);


        Assumptions.assumeTrue(books.getContent().size() > 0);

        log.info("[分页+排序+查询所有] - [{}]", books.getContent());

    }
}
