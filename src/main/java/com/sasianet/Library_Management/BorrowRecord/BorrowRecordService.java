package com.sasianet.Library_Management.BorrowRecord;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.Book.Books;

import java.util.List;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public List<BorrowRecords> getBorrowRecord() {
        return borrowRecordRepository.findAll();
    }

    public void addBorrowRecord(BorrowRecords borrowRecord) {
        borrowRecordRepository.save(borrowRecord);
    }

    public void updateBorrowRecord(BorrowRecords borrowRecord) {
        borrowRecordRepository.save(borrowRecord);
    }

    public List<BorrowRecords> getBorrowRecordsByMemberId(int memberId) {
        return borrowRecordRepository.findAllByMemberId(memberId);
    }
}
