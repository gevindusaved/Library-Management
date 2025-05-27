package com.sasianet.Library_Management.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    // @NotBlank(message = "Title is required")
    private String title;
    // @NotBlank(message = "Author is required")
    private String author;
    // @NotBlank(message = "ISBN is required")
    private String isbn;
    private Boolean available;
}
