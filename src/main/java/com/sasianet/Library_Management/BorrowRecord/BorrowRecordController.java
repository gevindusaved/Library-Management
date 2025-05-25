package com.sasianet.Library_Management.BorrowRecord;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public BorrowRecordController(BorrowRecordService borrowRecordService,
            BorrowRecordRepository borrowRecordRepository) {
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

    @GetMapping("/brecords/search/{query}")
    public List<BorrowRecords> searchBorrowRecords(@PathVariable String query) {
        try {
            int id = Integer.parseInt(query);

            // Try both as memberId and bookId
            List<BorrowRecords> byMemberId = borrowRecordService.getBorrowRecordsByMemberId(id);
            List<BorrowRecords> byBookId = borrowRecordService.getBorrowRecordsByBookId(id);

            // Merge and remove duplicates
            Set<BorrowRecords> results = new HashSet<>();
            results.addAll(byMemberId);
            results.addAll(byBookId);

            return new ArrayList<>(results);
        } catch (NumberFormatException e) {
            // Not a number — return empty or error
            return new ArrayList<>();
        }
    }

    @PutMapping("/brecords")
    public void updateBorrowRecord(@RequestBody BorrowRecords borrowRecord) {
        borrowRecordService.updateBorrowRecord(borrowRecord);
    }
}
