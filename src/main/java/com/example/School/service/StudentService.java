package com.example.School.service;
import com.example.School.Exception.ApiRequestException;
import com.example.School.Mappers.StudentMapper;
import com.example.School.model.DataResponse;
import com.example.School.model.Student;
import com.example.School.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;
//    @Autowired
//    private StudentMapper studentMapper;

    public List<Student> getAllStudents(){
        if (studentRepository.count() < 1)
            throw new ApiRequestException("No students exist");
        return studentRepository.findAll();
    }
    public DataResponse addStudent(Student student){
        studentRepository.save(student);
        return new DataResponse("Student Created ID: " + student.getId());
    }
    public DataResponse addStudents(List<Student> students){
        studentRepository.saveAll(students);
        return new DataResponse("Students added");
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null); //optional type may return null must useorelse
    }

    public DataResponse updateStudent(Long id, Student student) {
        Student existStudent = studentRepository.findById(id).orElse(null);
        if(existStudent != null) {
            //TODO se
            //set both name and major of current student to new values
            existStudent.setName(student.getName());
            existStudent.setMajor(student.getMajor());
            studentRepository.save(existStudent);
            return new DataResponse("Student id: " + existStudent.getId() + " updated.  current name: " + existStudent.getName() +
                    " current major: " + existStudent.getMajor());
        }
//        return new DataResponse( "Student not found");
        throw new ApiRequestException("Student id not found");
    }

    public DataResponse deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            studentRepository.delete(existingStudent);
            return new DataResponse("Student with id: "+id+" removed successfully.");
        }
        return new DataResponse("Student with id: " + id + " not found.");
    }
    public long countStudents(){
        return studentRepository.count();
    }

    public DataResponse patchStudent(Long id, Student student) {
        Student existStudent = studentRepository.findById(id).orElse(null);
        String string = "";
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
                string += "name changed to: " + newName;
            } else string += "name remains: " + existName;
            if (newMajor != null) {
                existStudent.setMajor(newMajor);
                string += "major changed to: " + newMajor;
            } else string += "major remains: " + existMajor;
            studentRepository.save(existStudent);
            return new DataResponse(string);
        }
        return new DataResponse("id "+id+" not found");
    }

    public DataResponse deleteAllStudents() {
        studentRepository.deleteAll();
        return new DataResponse( "Deleted all students");
    }
}
