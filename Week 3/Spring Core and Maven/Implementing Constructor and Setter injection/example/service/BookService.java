package org.example.service;

import org.example.repository.BookRepository;

public class BookService {
    private String bookTitle;
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void publishBook() {
        System.out.println("BookService: Publishing book - " + bookTitle);
        bookRepository.saveBook(bookTitle);
    }
}
