package com.sjsu.vansbackend.courses;

import com.sjsu.vansbackend.userModel.User;
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

  @ManyToOne User professor;

  @ManyToMany(mappedBy = "courses")
  List<User> students;

  Boolean isPublished;

  @Column(length = 10000)
  String syllabus;

  String term;

  public Course(
      String name,
      String description,
      User professor,
      Boolean isPublished,
      String syllabus,
      String term) {
    this.name = name;
    this.description = description;
    this.professor = professor;
    this.isPublished = isPublished;
    this.syllabus = syllabus;
    this.term = term;
  }
}
