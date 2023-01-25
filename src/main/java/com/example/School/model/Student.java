package com.example.School.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "name", nullable = false)
    private String name;
//    @Column(name = "major", nullable = false)
    private String major;
    @OneToMany(mappedBy = "student")
    private List<Classroom> classrooms;

}
