package com.example.School.Mapstruct;

import com.example.School.model.Classroom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

//    @JsonProperty("id")
    private Long Id;

//    @JsonProperty("name")
    private String name;
//    @JsonProperty("major")
    private String major;

    private String email;
    private List<Classroom> classrooms;

}
