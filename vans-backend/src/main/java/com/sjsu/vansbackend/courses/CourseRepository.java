package com.sjsu.vansbackend.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  // closer DB access, this is an Interface. Rest all are classes. 
public interface CourseRepository extends JpaRepository<Course, String> { // JPA is extended coz it is a interface, Springboot takes this interface and converts it to class utilising JPA 
//  List<Course> findByProfessorUsername(String username);

    Optional<Course> findCourseById(Integer id); // naming should be particular, springboot will define those methods automatically and this interface will be converted into a class

    List<Course> findCoursesByProfessorUsername(String username); //List<Course> is output and String username is input 

    List<Course> findCoursesByParticipantsUsername(String username);
}
