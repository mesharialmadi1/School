package com.example.School.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "StudentClassroom")
@Setter
@Getter
public class StudentClassroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "Student_Id")
    private Student student;
    @ManyToOne()
    @JoinColumn(name = "Classroom_Id")
    private Classroom classroom;

}
