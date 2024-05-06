package com.sjsu.vansbackend.userModel;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user") // Setting a prefix to all URI's below
public class UserController {

  @Autowired private UserService userService;

  @Autowired
    private PasswordEncoder passwordEncoder;

  @GetMapping("/")
  public String homeMessage() {
    return "Welcome to the home page";
  }

  @PostMapping("/save")
  public ResponseEntity<Object> saveUser(@RequestBody UserEntity user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    UserEntity res = userService.saveUser(user);
   if(res.getId() >0 ){
     return ResponseEntity.ok().body("User saved successfully");
   }else{
        return ResponseEntity.badRequest().body("Error. User not saved");
   }
  }

  @GetMapping("/all")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<Object> getAllUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @GetMapping("/single")
  @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
  public ResponseEntity<Object> getUserDetails() {
    return ResponseEntity.ok().body(userService.getUser(getLoggedUserInfo().getUsername()));
  }

  public UserEntity getLoggedUserInfo() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null && auth.getPrincipal() instanceof UserEntity) {
      return (UserEntity) auth.getPrincipal();
    }
    return null;
  }

}
