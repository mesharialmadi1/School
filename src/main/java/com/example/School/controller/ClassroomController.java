package com.example.School.controller;

import com.example.School.Mapstruct.ClassroomDto;
import com.example.School.model.Classroom;
import com.example.School.model.ClassroomRequest;
import com.example.School.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<?> addClassroom(@RequestBody ClassroomRequest classroomRequest) {
        return new ResponseEntity<>(classroomService.addClass(classroomRequest), HttpStatus.CREATED);
    }
    @PostMapping("/addClassrooms")
    public ResponseEntity<?> addClassrooms(@RequestBody List<ClassroomRequest> classroomsRequest) {
        return new ResponseEntity<>(classroomService.addClassrooms(classroomsRequest),HttpStatus.CREATED); //201
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClassroomById(@PathVariable Long id) {
        return new ResponseEntity<>(classroomService.getClassroomById(id), HttpStatus.OK); //200
    }

}
