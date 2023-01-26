package com.example.School.Mapstruct;

import com.example.School.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {
    private Long id;
    private Long roomNumber;

    private String building;

    private Student student;


}
