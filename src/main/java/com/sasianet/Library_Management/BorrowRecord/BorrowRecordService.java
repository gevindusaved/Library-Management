package com.sasianet.Library_Management.BorrowRecord;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.Book.BookRepository;
import com.sasianet.Library_Management.Book.Books;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;

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

        if (matchedBook.isPresent()) {
            Books book = matchedBook.get();
            if (book.getAvailable()) {
                borrowRecordRepository.save(borrowRecord);
                System.out.println("Borrow record added successfully.");
            } else {
                throw new IllegalStateException("Book cannot be borrowed");
            }
        } else {
            throw new IllegalStateException("Book with given ID does not exist.");
        }
    }

    public void updateBorrowRecord(BorrowRecords borrowRecord) {
        borrowRecordRepository.save(borrowRecord);
    }

    public List<BorrowRecords> getBorrowRecordsByMemberId(int memberId) {
        return borrowRecordRepository.findAllByMemberId(memberId);
    }

    public List<BorrowRecords> getBorrowRecordsByBookId(int bookId) {
        return borrowRecordRepository.findAllByBookId(bookId);
    }

    public void deleteBorrowRecord(int bRecordsId) {

        borrowRecordRepository.deleteById(bRecordsId);

    }
}
