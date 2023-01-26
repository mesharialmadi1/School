package com.example.School.service.Mappers;
import com.example.School.model.Student;
import com.example.School.model.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
//    StudentDto studentToStudentDto(Student student);

    @Mapping(target = "studentClassrooms", ignore = true)
    Student studentRequestToStudent(StudentRequest studentRequest);
//    List<StudentDto> studentsToStudentsDto(List<Student> students);
//    Student toStudent(StudentDto student);
}
