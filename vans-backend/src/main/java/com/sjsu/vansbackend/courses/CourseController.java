package com.sjsu.vansbackend.courses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Retrieve (GET Request)

    // Get course object based on courseId
    @GetMapping("/{courseId}")
    public Course getCourseInfo(@PathVariable String courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

    // Get all course objects
    @GetMapping("/list/student/{username}")
    public List<Course> getAllCoursesByStudentUsername(@PathVariable String username) {
        return courseService.getCoursesByStudentsUsername(username);
    }

    @GetMapping("/list/professor/{username}")
    public List<Course> getAllCoursesByProfessorUsername(@PathVariable String username) {
        return courseService.getCourseByProfessorUsername(username);
    }
}
