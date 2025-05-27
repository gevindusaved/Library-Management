package com.sasianet.Library_Management.Book;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.BorrowRecord.BorrowRecordRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public BookService(BookRepository bookRepository, BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public List<Books> searchBooks(String query) {
        try {
            Integer id = Integer.parseInt(query);
            Books book = getBookById(id);
            return book != null ? List.of(book) : List.of();
        } catch (NumberFormatException e) {
            Set<Books> results = new HashSet<>();
            results.addAll(getBooksByTitle(query));
            results.addAll(getBooksByAuthor(query));
            return new ArrayList<>(results);
        }
    }

    public List<Books> getBooks() {
        return bookRepository.findAll();
    }

    public Books getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void addBook(Books book) {
        book.setAvailable(true);
        bookRepository.save(book);
    }

    public void updateBook(Books book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer bookId) {
        Optional<Books> matchedBook = bookRepository.findAll().stream()
                .filter(book -> book.getBookId().equals(bookId))
                .findFirst();

        if (matchedBook.isPresent()) {
            Books book = matchedBook.get();
            if (book.getAvailable()) {
                bookRepository.deleteById(bookId);
                System.out.println("Book Deleted successfully");
            } else {
                throw new IllegalStateException("Book cannot be deleted");
            }
        } else {
            throw new IllegalStateException("Book with given ID does not exist.");
        }
    }

    public List<Books> getBooksByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public List<Books> getBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }
}
