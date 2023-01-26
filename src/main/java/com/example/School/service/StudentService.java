package com.example.School.service;
import com.example.School.Exception.ApiRequestException;
import com.example.School.service.Mappers.StudentMapper;
import com.example.School.model.*;
import com.example.School.repository.ClassroomRepository;
import com.example.School.repository.StudentClassroomRepository;
import com.example.School.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentClassroomRepository studentClassroomRepository;

    public List<Student> getAllStudents(){
        if (studentRepository.count() < 1)
            throw new ApiRequestException("No students exist");
        return studentRepository.findAll();
    }
//    public DataResponse addStudent(Student student){
//        studentRepository.save(student);
//        return new DataResponse("Student Created ID: " + student.getId());
//    }

    public DataResponse addStudent(StudentRequest studentRequest){
        List<Classroom> classrooms = classroomRepository.findAllById(studentRequest.getClassroomIds());
        Student student = studentMapper.studentRequestToStudent(studentRequest);  //map studentRequest to this student
        classrooms.forEach(classroom -> {
            StudentClassroom studentClassroom = new StudentClassroom();
            studentClassroom.setStudent(student);
            studentClassroom.setClassroom(classroom);
            studentClassroomRepository.save(studentClassroom);
        });
        studentRepository.save(student);
        return new DataResponse("Student Created ID: " + student.getId());
    }
//    public DataResponse addStudent(StudentRequest studentRequest){
//        Student student = new Student();
//        StudentClassroom studentClassroom = new StudentClassroom();
//        studentClassroom.setStudent(student);
//        studentClassroom.setClassroom(classroomRepository.findById((long)1).orElse(null));
//        List<StudentClassroom> classrooms;
//        student.setName(studentRequest.getName());
//        student.setMajor(studentRequest.getMajor());
//        studentRepository.save(student);
//        return new DataResponse("Student Created ID: " + student.getId());
//    }


    public DataResponse addStudents(List<Student> students){
        studentRepository.saveAll(students);
        return new DataResponse("Students added");
    }

    //optional type may return null must useorelse
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null)
            return student;
        throw new ApiRequestException("Student with id " + id + " does not exist");
    }

    public DataResponse updateStudent(Long id, Student student) {
        Student existStudent = studentRepository.findById(id).orElse(null);
        if(existStudent != null) {
            //TODO se
            //set both name and major of current student to new values
            existStudent.setName(student.getName());
            existStudent.setMajor(student.getMajor());
            studentRepository.save(existStudent);
            return new DataResponse("Student with id: " + existStudent.getId() +
                    " updated.  current name: " + existStudent.getName() +
                    " current major: " + existStudent.getMajor());
        }
//        return new DataResponse( "Student not found");
        throw new ApiRequestException("Student id not found");
    }

    public DataResponse deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            studentRepository.delete(existingStudent);
            return new DataResponse("Student with id: " + id + " removed successfully.");
        }
        throw new ApiRequestException("Student with id: " + id + " not found.");
    }
    public DataResponse countStudents(){
        return new DataResponse("Student count: " + studentRepository.count());
    }

    public DataResponse patchStudent(Long id, Student student) {
        Student existStudent = studentRepository.findById(id).orElse(null);
        String message = "";
//      error 500 if NULL
//      String existName = existStudent.getName();
//      String existMajor = existStudent.getMajor();
//      String newName = student.getName();
//      String newMajor = student.getMajor();

        if (existStudent != null) {
            String existName = existStudent.getName();
            String existMajor = existStudent.getMajor();
            String newName = student.getName();
            String newMajor = student.getMajor();
            if (newName != null) {           //stupid?
                existStudent.setName(newName);
                message += "name changed to: " + newName;
            } else message += "name remains: " + existName;
            if (newMajor != null) {
                existStudent.setMajor(newMajor);
                message += "major changed to: " + newMajor;
            } else message += "major remains: " + existMajor;
            studentRepository.save(existStudent);
            return new DataResponse(message);
        }
        throw new ApiRequestException("id "+id+" not found");
    }

    public DataResponse deleteAllStudents() {
        studentRepository.deleteAll();
        return new DataResponse( "Deleted all students");
    }

//    public DataResponse addToClassroom(Long studentId, Long classId) {
//        Student existStudent = studentRepository.findById(studentId).orElse(null);
//        Classroom newClassroom = classroomRepository.findById(classId).orElse(null);
//        List<Classroom> existClassrooms = existStudent.getClassrooms();
//        existClassrooms.add(newClassroom);
//        existStudent.setClassrooms(existClassrooms);
////        newClassroom.setStudent(existStudent);
//        studentRepository.save(existStudent);
////        classroomRepository.save(newClassroom);
//        return new DataResponse("Added student " +existStudent.getId()+" to classroom " + newClassroom.getId());
//    }
}
