package com.example.School.Mappers;
import com.example.School.Mapstruct.ClassroomDto;
import com.example.School.model.Classroom;
import com.example.School.model.ClassroomRequest;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring") //Important to specify the componentModel
public interface ClassroomMapper {
    ClassroomDto classroomToClassroomDto(Classroom classroom);
    Classroom classroomDtoToClassroom(ClassroomDto classroom);
    Classroom classroomRequestToClassroom(ClassroomRequest classroomRequest);

    List<Classroom> classroomRequestListToClassroomList(List<ClassroomRequest> classroomRequest);
}
