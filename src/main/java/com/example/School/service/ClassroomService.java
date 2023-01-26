package com.example.School.service;

import com.example.School.model.Classroom;
import com.example.School.model.DataResponse;
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

    public DataResponse addClass(Classroom classroom){
        classroomRepository.save(classroom);
        return new DataResponse("Added");
    }

}
