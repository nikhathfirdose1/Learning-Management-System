package com.sjsu.vansbackend.courses;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
//  List<Course> findByProfessorUsername(String username);

  Optional<Course> findCourseByCourseId(String courseId);

//  List<Course> findCoursesByProfessorUsername(String username);
//
//  List<Course> findCoursesByStudentsUsername(String username);
}
