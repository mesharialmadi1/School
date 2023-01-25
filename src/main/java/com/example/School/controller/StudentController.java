package com.example.School.controller;
import com.example.School.model.Student;
import com.example.School.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//  only endpoints and HTTP status

@RestController
//  default path
@RequestMapping("/api/students")
public class StudentController {

//    @ExceptionHandler()
//    public ResponseEntity<?> handleExceptionError(Exception exception) {
//        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
//    }

    @Autowired
    StudentService studentService;
//  empty will use request mapping
    @GetMapping()
//    ResponseEntity represents the whole HTTP response: status code, headers, and body
//    question mark means get whatever data type is there
//    could also use ResponseEntity<Student> But this is less flexible
    public ResponseEntity<?> getAll() {
//      HTTP STATUS:
//        200 - 299 = success, request receive, understood and accepted
//        300 - 399 = Redirect, request was received but further action is required from the client end
//        400 - 499 = business error, incorrect request, logic error?
//        500 - 599 = server error, server failed to handle request
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> newStudents(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED); //201
    }

    //only change path when doing something else
    @PostMapping("/addStudents")
    public ResponseEntity<?> newStudent(@RequestBody List<Student> students) { //object array?
        return new ResponseEntity<>(studentService.addStudents(students),HttpStatus.CREATED); //201
    }
    @GetMapping("/{id}")//git branch test
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK); //200
     }

     //PathVariable(name = "id") if variable names are different
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id2, @RequestBody Student s) {
        return new ResponseEntity<>(studentService.updateStudent(id2,s), HttpStatus.OK);
     }
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStudent(@PathVariable Long id, @RequestBody Student s) {
        return new ResponseEntity<>(studentService.patchStudent(id,s), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllStudents() {
        return new ResponseEntity<>(studentService.deleteAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count() {
        return new ResponseEntity<>(studentService.countStudents(), HttpStatus.OK); //200
    }

}


