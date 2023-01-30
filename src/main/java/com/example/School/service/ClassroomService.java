package com.example.School.service;

import com.example.School.Exception.ApiRequestException;
import com.example.School.model.Classroom;
import com.example.School.model.DataResponse;
import com.example.School.model.Student;
import com.example.School.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }
    public Classroom getClassroomById(Long id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if (classroom != null)
            return classroom;
        throw new ApiRequestException("classroom with id " + id + " does not exist");
    }
    public DataResponse addClass(Classroom classroom){
        classroomRepository.save(classroom);
        return new DataResponse("Added");
    }
    public DataResponse addClassrooms(List<Classroom> classrooms){
        classroomRepository.saveAll(classrooms);
        return new DataResponse("Classrooms added");
    }


}
