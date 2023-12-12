package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Enter valid Email")
    @Size(max = 30,min = 10)
    @Column(columnDefinition = "varchar(30) unique")
    private String email;
    @NotEmpty(message = " password should not be Empty")
    @Size(max = 10,min = 8,message = "password must be more than 8 and less than 10")
    @Pattern(regexp = "^(?=.*\\d).{8,}$\n")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;
    @NotEmpty(message = "phone number should not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phone;
    @NotEmpty(message = " first name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(10) not null")
    private String firstName;
    @NotEmpty(message = " Last name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(10) not null")
    private String lastName;
    @NotNull(message = "age should not be empty")
    @Positive(message = "age must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer age ;
}
