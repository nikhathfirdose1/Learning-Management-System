package com.sjsu.vansbackend.assignmentSubmissions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignment-submissions")
public class AssignmentSubmissionController {
    private final AssignmentSubmissionService assignmentSubmissionService;

    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
    }

    // Retrieve (GET Request)
    @GetMapping("/add")
    public AssignmentSubmission addAssignmentSubmission(AssignmentSubmission assignmentSubmission) {
        return assignmentSubmissionService.addAssignmentSubmission(assignmentSubmission);
    }

    @GetMapping("/update")
    public void updateAssignmentSubmission(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionService.updateAssignmentSubmission(assignmentSubmission);
    }

    @GetMapping("/{assignmentSubmissionId}")
    public AssignmentSubmission getAssignmentSubmissionById(@PathVariable Integer assignmentSubmissionId) {
        return assignmentSubmissionService.getAssignmentSubmissionById(assignmentSubmissionId);
    }
    @GetMapping("/list/{assignmentId}")
    public List<AssignmentSubmission> getAssignmentSubmissionsByAssignmentId(@PathVariable Integer assignmentId) {
        return assignmentSubmissionService.getAssignmentSubmissionsByAssignmentId(assignmentId);
    }
}
