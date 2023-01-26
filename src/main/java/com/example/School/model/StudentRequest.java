package com.example.School.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import java.util.List;

@Setter
@Getter
public class StudentRequest {
    private String name;
    private String major;
    private List<Long> classroomIds;
}
