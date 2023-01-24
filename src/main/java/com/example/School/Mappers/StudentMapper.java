package com.example.School.Mappers;
import com.example.School.Mapstruct.StudentDto;
import com.example.School.model.Student;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper
public interface StudentMapper {
    StudentDto studentToStudentDto(Student student);
//    StudentDto studentsToStudentsDto(List<Student> students);
//    Student toStudent(StudentDto student);
}
