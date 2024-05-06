package com.sjsu.vansbackend.assignments;

import com.sjsu.vansbackend.assignmentSubmissions.AssignmentSubmission;
import com.sjsu.vansbackend.courses.Course;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Assignment {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String name;


   private String dueDate;

    @Column(length = 10000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSubmission> assignmentSubmission;

    public Assignment(String name, String dueDate, String description, Course course) {
        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
        this.course = course;
    }

}
