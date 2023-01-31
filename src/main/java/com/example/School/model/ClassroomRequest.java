package com.example.School.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClassroomRequest {
    @NotNull
    @NotBlank
//    @Range(min = 1, max = 500)
    @Size(min = 0, max = 5)
    private long roomNumber;
    @NotNull
    private String building;
}
