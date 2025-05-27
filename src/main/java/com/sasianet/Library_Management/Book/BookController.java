package com.sasianet.Library_Management.Book;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RestController
public class BookController {

    private final BookService bookService;

    // Constructor injection (no need for @Autowired)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Books> getBook() {
        return bookService.getBooks();
    }

    // @GetMapping("/books/id/{bookId}")
    // public Books getBook(@PathVariable int bookId) {
    // return bookService.getBookById(bookId);
    // }

    // @GetMapping("/books/title/{title}")
    // public List<Books> getTitle(@PathVariable String title) {
    // return bookService.getBooksByTitle(title);
    // }

    // @GetMapping("/books/author/{author}")
    // public List<Books> getAuthor(@PathVariable String author) {
    // return bookService.getBooksByAuthor(author);
    // }

    @GetMapping("/books/search/{query}")
    public List<Books> searchBooks(@PathVariable String query) {
        return bookService.searchBooks(query);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Books book) {
        bookService.addBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Books book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}
