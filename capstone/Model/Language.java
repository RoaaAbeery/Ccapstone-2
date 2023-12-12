package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Language name should not be empty")
    @Size(max = 10,message = "Language name must be less than 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String language_name;
    @NotEmpty(message = "Language description should not be empty")
    @Size(min =100 ,max = 250,message = "Language description must be more than 100 and less than 250")
    @Column(columnDefinition = "varchar(250) not null")
    private String language_description;
    @NotEmpty(message = "version must be not Empty")
    @Size(min = 4,max = 10, message = "version must be more than 4 and less than 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String version;

}
