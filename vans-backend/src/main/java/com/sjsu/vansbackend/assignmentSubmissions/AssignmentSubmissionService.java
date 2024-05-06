package com.sjsu.vansbackend.assignmentSubmissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentSubmissionService {

    @Autowired
    AssignmentSubmissionRepository assignmentSubmissionRepository;

    public AssignmentSubmission addAssignmentSubmission(AssignmentSubmission assignmentSubmission) {
        return assignmentSubmissionRepository.save(assignmentSubmission);
    }

    public void updateAssignmentSubmission(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionRepository.save(assignmentSubmission);
    }

    public AssignmentSubmission getAssignmentSubmissionById(Integer assignmentSubmissionId) {
        return assignmentSubmissionRepository.findById(assignmentSubmissionId).orElse(null);
    }

public List<AssignmentSubmission> getAssignmentSubmissionsByAssignmentId(Integer assignmentId) {
        return assignmentSubmissionRepository.findByAssignmentId(assignmentId);
    }


}
