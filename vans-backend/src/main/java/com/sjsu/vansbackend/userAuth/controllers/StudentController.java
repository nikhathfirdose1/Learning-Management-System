package com.sjsu.vansbackend.userAuth.controllers;

import com.sjsu.vansbackend.userAuth.models.ApplicationUser;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @GetMapping("/")
    public String helloUserController(){

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name = user.getUsername();

        return "Student access level ";
    }
    
}
