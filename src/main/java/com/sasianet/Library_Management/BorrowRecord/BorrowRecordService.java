package com.sasianet.Library_Management.BorrowRecord;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.Book.BookRepository;
import com.sasianet.Library_Management.Book.Books;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;

    public LocalDateTime rightNowDateTime() {
        return LocalDateTime.now();
    }

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
    }

    public List<BorrowRecords> getBorrowRecord() {
        return borrowRecordRepository.findAll();
    }

    public void addBorrowRecord(BorrowRecords borrowRecord) {
        Optional<Books> matchedBook = bookRepository.findAll().stream()
                .filter(book -> book.getBookId().equals(borrowRecord.getBookId()))
                .findFirst();
        // Optional<BorrowRecords> matchedBorrowRecord =
        // borrowRecordRepository.findAll().stream()
        // .filter(bookRecord ->
        // bookRecord.getBookId().equals(borrowRecords.getBookId())
        // && bookRecord.getReturnDate() == null
        // && borrowRecords.getMemberId().equals(bookRecord.getMemberId()))
        // .findFirst();
        if (matchedBook.isPresent()) {
            Books book = matchedBook.get();
            if (book.getAvailable() == true) {
                book.setAvailable(false);
                borrowRecord.setBorrowDate(rightNowDateTime());
                borrowRecordRepository.save(borrowRecord);
                System.out.println("Borrow record added successfully.");
            } else {
                throw new IllegalStateException("Book cannot be borrowed");
            }
        } else {
            throw new IllegalStateException("Book with given ID does not exist.");
        }
    }

    public void updateBorrowRecord(BorrowRecords borrowRecords) {
        Optional<Books> matchedBook = bookRepository.findAll().stream()
                .filter(book -> book.getBookId().equals(borrowRecords.getBookId()))
                .findFirst();

        Optional<BorrowRecords> matchedBorrowRecord = borrowRecordRepository.findAll().stream()
                .filter(bookRecord -> bookRecord.getBookId().equals(borrowRecords.getBookId())
                        && bookRecord.getReturnDate() == null
                        && borrowRecords.getMemberId().equals(bookRecord.getMemberId()))
                .findFirst();

        if (matchedBook.isPresent()) {
            Books book = matchedBook.get();
            BorrowRecords borrowRecord = matchedBorrowRecord.get();
            if (matchedBorrowRecord.isPresent() && !book.getAvailable()) {
                book.setAvailable(true);
                borrowRecord.setReturnDate(rightNowDateTime());
                borrowRecordRepository.save(borrowRecord);
                System.out.println("Book Returned successfully.");
            } else {
                throw new IllegalStateException("Book cannot be borrowed");
            }
        } else {
            throw new IllegalStateException("Book with given ID does not exist.");
        }
    }

    public List<BorrowRecords> getBorrowRecordsByMemberId(Integer memberId) {
        return borrowRecordRepository.findAllByMemberId(memberId);
    }

    public List<BorrowRecords> getBorrowRecordsByBookId(Integer bookId) {
        return borrowRecordRepository.findAllByBookId(bookId);
    }

    public void deleteBorrowRecord(Integer bRecordsId) {

        borrowRecordRepository.deleteById(bRecordsId);

    }
}
