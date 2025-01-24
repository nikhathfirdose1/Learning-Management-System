package com.sjsu.vansbackend.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDAO { // object that is sent from FE, ie the response 

    private Integer id;
    private String syllabus;
    private String professor;
}
