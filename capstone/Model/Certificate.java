package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "user id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotNull(message = "tutorial id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer tutorial_id;
    @Column(columnDefinition = "date")
    private LocalDate certificate_date;
    @NotEmpty(message = "certificate name should not be empty ")
    @Column(columnDefinition = "varchar(10)")
    private String certificate_name;
}
