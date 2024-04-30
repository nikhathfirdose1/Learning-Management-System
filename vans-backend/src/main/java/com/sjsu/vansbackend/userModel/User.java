package com.sjsu.vansbackend.userModel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) // Automatically Generate a value
  private Integer id;

  @Column(unique = true, length = 128) // Unique Key
  private String username;

  private String name;

  private String password;

  private Integer roles;

  private boolean active;

  @Column(unique = true, length = 128) // Unique Key
  private String email;

  private String description;

  private String address;

  private String status;

  // Constructor
  public User() {}

  public User(String username) {
    this.username = username;
  }

  public User(
      String name,
      String password,
      String username,
      Integer roles,
      boolean active,
      String email,
      String description,
      String address,
      String status) {
    this.name = name;
    this.password = password;
    this.username = username;
    this.roles = roles;
    this.active = active;
    this.email = email;
    this.description = description;
    this.address = address;
    this.status = status;
  }

  public User(
      String name,
      String username,
      Integer roles,
      boolean active,
      String email,
      String description,
      String address,
      String status) {
    this.name = name;
    this.username = username;
    this.roles = roles;
    this.active = active;
    this.email = email;
    this.description = description;
    this.address = address;
    this.status = status;
  }
}
