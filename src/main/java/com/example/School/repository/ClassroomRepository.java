package com.example.School.repository;

import com.example.School.model.Classroom;
import com.example.School.model.ClassroomRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    //Translate to sql
    Optional<Classroom> findByRoomNumberAndBuilding(Long roomNumber, String Building);
//    List<Optional<Classroom>> findAllNotDistinctByRoomNumberInClassroomAndBuildingInClassroom(List<ClassroomRequest> classrooms);
    List<Classroom> findAllNotDistinctByRoomNumberInAndBuildingIn(List<ClassroomRequest> classrooms);
}
