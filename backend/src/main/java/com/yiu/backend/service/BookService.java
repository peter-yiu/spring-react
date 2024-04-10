package com.yiu.backend.service;

import com.yiu.backend.model.Book;
import com.yiu.backend.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Integer id, Book updatedBook) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setDescription(updatedBook.getDescription());
            return bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Book with id " + id + " not found");
        }


    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Page<Book> getAllBooksByPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public List<Book> findAllByTitle(String title) {

        return bookRepository.findAllByTitleContaining(title);
    }

}
