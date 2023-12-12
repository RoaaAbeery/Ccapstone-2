package com.example.capstone.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "language id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer language_id;
    @NotNull(message = "user id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotEmpty(message = "Tutorial description should not be empty")
    @Size(max = 250)
    @Column(columnDefinition = "varchar(250) not null")
    private String tutorial_description;
    @NotEmpty(message = " title should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty(message = "content should not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String content;
    @NotEmpty(message = "Author should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;
    @Column(columnDefinition = "date")
    private LocalDate published_Date;
    @Column(columnDefinition = "varchar(10) Check (difficulty_level='Hard' or difficulty_level='Medium' or difficulty_level='Easy')")
    @Pattern(regexp = "^(Hard|Medium|Easy)$")
    private String difficulty_level;
    @NotNull(message = "favorites should not be null")
    @Column(columnDefinition = "Boolean not null")
    private Boolean favorites;

}
