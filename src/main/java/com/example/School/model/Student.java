package com.example.School.model;

import com.example.School.Validation.IsAlphabetic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "student")
//@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Max(value = 5,message = "Max number of students")
//    @Min(value = 10,message = "Min number of students")
    @Range(min = 0, max = 1000)
//    @Positive
    private Long id;
    @NotNull
    @NotBlank
    @IsAlphabetic() //custom validator
    private String name;

    @NotNull
    @NotBlank
    private String major;
    @Email(message = "Does not match email format")
    @Pattern(message = "Does not match email pattern", regexp = "^\\w+@\\w+\\.\\w+$", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull(message = "null email")
    @NotBlank
    private String email;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StudentClassroom> studentClassrooms;

}
