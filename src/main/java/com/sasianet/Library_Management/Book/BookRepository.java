package com.sasianet.Library_Management.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findAllByTitle(String title);
    List<Books> findAllByAuthor(String author);
}