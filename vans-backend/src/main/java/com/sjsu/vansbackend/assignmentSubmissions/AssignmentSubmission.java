package com.sjsu.vansbackend.assignmentSubmissions;

import com.sjsu.vansbackend.assignments.Assignment;
import com.sjsu.vansbackend.grades.Grade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String submissionDateAndTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @OneToOne
    private Grade grade;


    public AssignmentSubmission(String submissionDateAndTime, Assignment assignment) {
        this.submissionDateAndTime = submissionDateAndTime;
        this.assignment = assignment;
    }
}
