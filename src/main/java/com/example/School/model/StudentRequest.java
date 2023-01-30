package com.example.School.model;

import com.example.School.Validation.IsAlphabetic;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
public class StudentRequest {
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
    private List<Long> classroomIds;
}
