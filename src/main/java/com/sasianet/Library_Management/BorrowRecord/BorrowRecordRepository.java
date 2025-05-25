package com.sasianet.Library_Management.BorrowRecord;

import com.sasianet.Library_Management.Book.Books;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecords, Integer> {
    Optional<BorrowRecords> findById(int bRecordsId);
    List<BorrowRecords> findAllByMemberId(int memberId);
    List<BorrowRecords> findAllByBookId(int bookId);
}
