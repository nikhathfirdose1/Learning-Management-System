package com.sjsu.vansbackend.userModel;

import com.sjsu.vansbackend.courses.Course;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) // Automatically Generate a value
  private Integer id;
  @Column(unique = true, length = 128) // Unique Key
  private String email;

  private String password;

  private String roles;

  @Column(unique = true, length = 128) // Unique Key
  private String username;

  private boolean active;

  private String description;

  private String address;

  private String status;

  @ManyToMany(mappedBy = "students")
    private List<Course> studentCourses;

  @OneToMany(mappedBy = "professor")
    private List<Course> proffCourses;

  // Constructor
  public UserEntity() {}

  public UserEntity(String username) {
    this.username = username;
  }

  public UserEntity(
          String name,
          String password,
          String username,
          String roles,
          boolean active,
          String email,
          String description,
          String address,
          String status) {

    this.password = password;
    this.username = username;
    this.roles = roles;
    this.active = active;
    this.email = email;
    this.description = description;
    this.address = address;
    this.status = status;
  }

  public UserEntity(
          String name,
          String username,
          String roles,
          boolean active,
          String email,
          String description,
          String address,
          String status) {

    this.username = username;
    this.roles = roles;
    this.active = active;
    this.email = email;
    this.description = description;
    this.address = address;
    this.status = status;
  }

  public UserEntity(
          String name,
          String password,
          String username,
          String roles,
          String email) {

    this.username = username;
    this.roles = roles;
    this.email = email;
    this.password = password;
    this.address = address;
    this.status = status;
  }
}