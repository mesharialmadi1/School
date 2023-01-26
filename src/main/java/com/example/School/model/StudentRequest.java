package com.example.School.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentRequest {
    private String name;
    private String major;
    private String email;
    private List<Long> classroomIds;
}
