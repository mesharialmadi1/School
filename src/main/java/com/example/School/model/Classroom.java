package com.example.School.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "Classroom")
@Getter
@Setter
public class Classroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long roomNumber;
    @NotNull
    private String building;

    //FetchType.LAZY: fetch data only when needed
    //FetchType.EAGER: fetch all data at once.
}
