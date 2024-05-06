package com.sjsu.vansbackend.courses;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  //    public void addCourse(Course course) {
  //        courseRepository.save(course);
  //    }

  public Course getCourseByCourseId(String courseId) {
    return courseRepository.findCourseByCourseId(courseId).orElse(null);
  }

  public void updateCourse(Course course) {
    courseRepository.save(course);
  }

//  public List<Course> getCourseByProfessorUsername(String username) {
//    return courseRepository.findCoursesByProfessorUsername(username);
//  }
//
//  public List<Course> getCoursesByStudentsUsername(String username) {
//    return courseRepository.findCoursesByStudentsUsername(username);
//  }

  //    public void deleteCourse(String courseId) {
  //        courseRepository.deleteById(courseId);
  //    }
}
