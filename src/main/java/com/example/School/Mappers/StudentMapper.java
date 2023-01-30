package com.example.School.Mappers;
import com.example.School.Mapstruct.StudentDto;
import com.example.School.model.Student;
import com.example.School.model.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class); //google this
    StudentDto studentToStudentDto(Student student);
//    @Mapping() Annotation is used when the source field names differ

    @Mapping(target = "studentClassrooms", ignore = true) //by default @Mapping ignore different named properties
    Student studentRequestToStudent(StudentRequest studentRequest);
    List<StudentDto> studentsToStudentsDto(List<Student> students);

}
