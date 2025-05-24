package com.sasianet.Library_Management.Book;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.BorrowRecord.BorrowRecordRepository;
import com.sasianet.Library_Management.BorrowRecord.BorrowRecords;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public BookService(BookRepository bookRepository, BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public List<Books> getBooks() {
        return bookRepository.findAll();
    }

    public Books getBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void addBook(Books book) {
        bookRepository.save(book);
    }

    public void updateBook(Books book) {
        bookRepository.save(book);
    }

    public void deleteBook(int bookId) {
        List<BorrowRecords> borrowRecords = borrowRecordRepository.findAll();

        boolean isCurrentlyBorrowed = borrowRecords.stream()
            .anyMatch(record -> record.getBookId() == bookId && record.getReturnDate() == null);

        System.out.println(isCurrentlyBorrowed);

        if (!isCurrentlyBorrowed) {
            bookRepository.deleteById(bookId);
        } else {
            throw new IllegalStateException("Cannot delete book: it has not been returned yet.");
        }
    }


    public List<Books> getBooksByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public List<Books> getBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }
}
