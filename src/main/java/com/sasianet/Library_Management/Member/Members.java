package com.sasianet.Library_Management.Member;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String name;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate membershipDate;

}
