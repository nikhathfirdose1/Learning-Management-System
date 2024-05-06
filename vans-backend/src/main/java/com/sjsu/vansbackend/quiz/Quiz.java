package com.sjsu.vansbackend.quiz;

import com.sjsu.vansbackend.courses.Course;
import com.sjsu.vansbackend.quizSubmissions.QuizSubmission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String quizDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "quiz")
    private List<QuizSubmission> quizSubmission;


    public Quiz(String name, String quizDate, Course course) {
        this.name = name;
        this.quizDate = quizDate;
        this.course = course;
    }

}

