package com.example.School.controller;

import com.example.School.model.Classroom;
import com.example.School.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(classroomService.getAllClassrooms(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addClassroom(@RequestBody Classroom classroom) {
        return new ResponseEntity<>(classroomService.addClass(classroom), HttpStatus.CREATED);
    }
}
