package com.sjsu.vansbackend.courses;

import com.sjsu.vansbackend.assignments.Assignment;
import com.sjsu.vansbackend.quiz.Quiz;
import com.sjsu.vansbackend.userAuth.models.ApplicationUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String courseId;
  private String name;
  private String description;
  private Boolean isPublished;

  @Column(length = 10000)
  private String syllabus;

  private String term;

  @ManyToOne
  private ApplicationUser professor;

  @ManyToMany(mappedBy = "enrolledCourses")
  private Set<ApplicationUser> participants;


  @OneToMany(mappedBy = "course")
  private List<Assignment> assignments;

  @OneToMany(mappedBy = "course")
  private List<Quiz> quizzes;

}
