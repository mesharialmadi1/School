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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Classroom classroom;

}
