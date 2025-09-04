package com.sasianet.Library_Management.BorrowRecord;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BorrowRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bRecordsId;
    private Integer memberId;
    private Integer bookId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnDate;

}
