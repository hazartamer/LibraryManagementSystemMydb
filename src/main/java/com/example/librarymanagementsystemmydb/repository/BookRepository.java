package com.example.librarymanagementsystemmydb.repository;

import com.example.librarymanagementsystemmydb.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByName(String name);
    Optional<Book> findByIsBorrowed(boolean isBorrowed);
}
