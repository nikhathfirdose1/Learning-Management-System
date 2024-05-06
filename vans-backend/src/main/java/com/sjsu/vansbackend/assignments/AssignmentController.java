package com.sjsu.vansbackend.assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

     @Autowired
     private AssignmentService assignmentService;

     @PostMapping("/add")
     public Assignment addAssignment(@RequestBody Assignment assignment) {
         return assignmentService.addAssignment(assignment);
     }

     @PutMapping("/update")
     public void updateAssignment(@RequestBody Assignment assignment) {
         assignmentService.updateAssignment(assignment);
     }


     @DeleteMapping("/delete/{assignmentId}")
     public void deleteAssignment(@PathVariable Integer assignmentId) {
         assignmentService.deleteAssignment(assignmentId);
     }

    @GetMapping("/{assignmentId}")
    public Assignment getAssignmentById(@PathVariable Integer assignmentId) {
        return assignmentService.getAssignmentById(assignmentId);
    }
    @GetMapping("/list/{courseId}")
    public List<Assignment> getAssignmentsByCourseId(@PathVariable String courseId) {
        return assignmentService.getAssignmentsByCourseId(courseId);
    }

}
