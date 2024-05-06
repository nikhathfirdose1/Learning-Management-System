package com.sjsu.vansbackend.userModel;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;
// Create
  public void addUser(UserEntity user) {
    userRepository.save(user);
  }

  public UserEntity getUser(String email) {
    return userRepository.findByEmail(email);
  }
  public List<UserEntity> getAllUsers() {
    return new ArrayList<>(userRepository.findAll());
  }


  public UserEntity saveUser(UserEntity user) {

    user.setUsername(user.getUsername());
    user.setEmail(user.getEmail());
    user.setPassword(user.getPassword());
    userRepository.save(user);
    return user;
  }

  // Update
  public void updateUser(UserEntity user) {
    userRepository.save(user);
  }

  // Delete
  public void deleteUser(String username) {
    userRepository.deleteById(username);
  }


}
