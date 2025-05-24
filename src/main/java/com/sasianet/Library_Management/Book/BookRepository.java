package com.sasianet.Library_Management.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    Optional<Books> findById(int bookId);
    List<Books> findAllByTitle(String title);
    List<Books> findAllByAuthor(String author);
}