package com.sasianet.Library_Management.BorrowRecord;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BorrowRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bRecordsId;
    private int memberId;
    private int bookId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

}
