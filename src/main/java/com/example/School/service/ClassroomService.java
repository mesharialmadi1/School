package com.example.School.service;

import com.example.School.Exception.ApiRequestException;
import com.example.School.Mappers.ClassroomMapper;
import com.example.School.Mapstruct.ClassroomDto;
import com.example.School.model.Classroom;
import com.example.School.model.ClassroomRequest;
import com.example.School.model.DataResponse;
import com.example.School.model.Student;
import com.example.School.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    ClassroomMapper classroomMapper;
    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }
    public Classroom getClassroomById(Long id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if (classroom != null)
            return classroom;
        throw new ApiRequestException("classroom with id " + id + " does not exist");
    }
    public DataResponse addClass(ClassroomRequest classroomRequest){
        Optional<Classroom> classroom = classroomRepository.findByRoomNumberAndBuilding(
                classroomRequest.getRoomNumber(), classroomRequest.getBuilding());
        if(classroom.isPresent()){
            throw new ApiRequestException("Room number already exists in building");
        }
        classroomRepository.save(classroomMapper.classroomRequestToClassroom(classroomRequest));//
        return new DataResponse("Added");
    }
    public DataResponse addClassrooms(List<ClassroomRequest> classroomRequests){
        List<Classroom> classrooms = classroomRepository.
                findAllNotDistinctByRoomNumberInAndBuildingIn(classroomRequests);
        if(classrooms.isEmpty()){
            classroomRepository.saveAll(classroomMapper.classroomRequestListToClassroomList(classroomRequests));
            return new DataResponse("Classrooms added");
        }
        throw new ApiRequestException("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }


}
