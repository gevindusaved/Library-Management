package com.sasianet.Library_Management.BorrowRecord;

import com.sasianet.Library_Management.Book.BookService;
import com.sasianet.Library_Management.Book.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;
    private final BorrowRecordRepository borrowRecordRepository;
    public BorrowRecordController(BorrowRecordService borrowRecordService, BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.borrowRecordService = borrowRecordService;
    }

    @GetMapping("/brecords")
    public List<BorrowRecords> getBorrowRecord() {
        return borrowRecordService.getBorrowRecord();
    }

    @PostMapping("/brecords")
    public void addBorrowRecord(@RequestBody BorrowRecords borrowRecord) {
        int bookId = borrowRecord.getBookId();
    
        List<BorrowRecords> borrowRecords = borrowRecordRepository.findAll();
        boolean isCurrentlyBorrowed = borrowRecords.stream()
            .anyMatch(record -> record.getBookId() == bookId && record.getReturnDate() == null);
    
        System.out.println("Book currently borrowed: " + isCurrentlyBorrowed);
    
        if (!isCurrentlyBorrowed) {
            borrowRecordService.addBorrowRecord(borrowRecord);
        } else {
            throw new IllegalStateException("Cannot borrow book: it has not been returned yet.");
        }
    }

    @GetMapping("/brecords/member/{memberId}")
    public List<BorrowRecords> getMemberRecords(@PathVariable int memberId) {
        return borrowRecordService.getBorrowRecordsByMemberId(memberId);
    }    

    @PutMapping("/brecords")
    public void updateBorrowRecord (@RequestBody BorrowRecords borrowRecord) {
        borrowRecordService.updateBorrowRecord(borrowRecord);
    }
}
