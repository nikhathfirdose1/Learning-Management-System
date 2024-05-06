package com.sjsu.vansbackend.assignmentSubmissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Integer> {


    List<AssignmentSubmission> findByAssignmentId(Integer assignmentId);


}
