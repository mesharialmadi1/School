package com.example.School.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Classroom")
@Getter
@Setter
public class Classroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomNumber;
    private String building;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Student student;

}
