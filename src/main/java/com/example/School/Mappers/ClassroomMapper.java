package com.example.School.Mappers;
import com.example.School.Mapstruct.ClassroomDto;
import com.example.School.model.Classroom;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDto ClassroomToClassroomtDto(Classroom classroom);
}
