package com.example.School.Mapstruct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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

}
