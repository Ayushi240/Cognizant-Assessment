package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You don’t need to implement anything, Spring Boot does it
}
