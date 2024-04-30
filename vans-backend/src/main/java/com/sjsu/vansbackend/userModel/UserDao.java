package com.sjsu.vansbackend.userModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
  private String username;
  private String name;
  private String password;
  private Integer roles;
  private boolean active;
  private String email;
  private String description;
  private String address;
  private String status;
}
