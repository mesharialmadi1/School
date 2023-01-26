package com.example.School.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "student")
//@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "name", nullable = false)
    @NotNull
    private String name;
//    @Column(name = "major", nullable = false)
    @NotNull
    private String major;
    @Email
    @NotNull
    private String email;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StudentClassroom> studentClassrooms;

}
