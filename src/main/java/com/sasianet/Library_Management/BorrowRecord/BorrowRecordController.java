package com.sasianet.Library_Management.BorrowRecord;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasianet.Library_Management.Book.BookRepository;
import com.sasianet.Library_Management.Book.Books;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RestController
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;

    public BorrowRecordController(BorrowRecordService borrowRecordService,
            BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.borrowRecordService = borrowRecordService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/brecords")
    public List<BorrowRecords> getBorrowRecord() {
        return borrowRecordService.getBorrowRecord();
    }

    @PostMapping("/brecords")
    public void addBorrowRecord(@RequestBody BorrowRecords borrowRecord) {
        borrowRecordService.addBorrowRecord(borrowRecord);
    }

    @GetMapping("/brecords/book/{bookId}")
    public List<BorrowRecords> getBorrowRecordsByBook(@PathVariable Integer bookId) {
        return borrowRecordService.getBorrowRecordsByBookId(bookId);
    }

    @GetMapping("/brecords/member/{memberId}")
    public List<BorrowRecords> getBorrowRecordsByMember(@PathVariable Integer memberId) {
        return borrowRecordService.getBorrowRecordsByMemberId(memberId);
    }

    @PutMapping("/brecords")
    public void updateBorrowRecord(@RequestBody BorrowRecords borrowRecords) {
        borrowRecordService.updateBorrowRecord(borrowRecords);
    }

    @DeleteMapping("/brecords/{bRecordsId}")
    public void deleteBorrowRecord(@PathVariable Integer bRecordsId) {
        borrowRecordService.deleteBorrowRecord(bRecordsId);
    }
}
