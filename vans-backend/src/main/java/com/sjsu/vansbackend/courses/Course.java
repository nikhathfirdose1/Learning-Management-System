package com.sjsu.vansbackend.courses;

import com.sjsu.vansbackend.assignments.Assignment;
import com.sjsu.vansbackend.quiz.Quiz;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
  @Id String courseId;

  String name;

  String description;

//  @ManyToOne
//  @JoinTable(name = "professor")
//  UserEntity professor;
//
//  @ManyToMany
//  @JoinTable(name = "students")
//  List<UserEntity> students;

  Boolean isPublished;

  @Column(length = 10000)
  String syllabus;

  String term;

  @OneToMany(mappedBy = "course")
    List<Assignment> assignments;

  @OneToMany(mappedBy = "course")
    List<Quiz> quizzes;


  public Course(
      String name,
      String description,

      Boolean isPublished,
      String syllabus,
      String term) {
    this.name = name;
    this.description = description;
    this.isPublished = isPublished;
    this.syllabus = syllabus;
    this.term = term;

  }
}
