package com.example.School.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "Classroom")
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNumber;
    private String building;
    @ManyToOne()
    private Student student;

}
