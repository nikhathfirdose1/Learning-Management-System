package com.sjsu.vansbackend.userAuth.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
@CrossOrigin("*")
public class FacultyController {

    @GetMapping("/")
    public String helloFacultyController(){
        return "Faculty level access";
    }

}
