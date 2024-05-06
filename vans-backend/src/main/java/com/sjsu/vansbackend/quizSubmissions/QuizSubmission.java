package com.sjsu.vansbackend.quizSubmissions;

import com.sjsu.vansbackend.grades.Grade;
import com.sjsu.vansbackend.quiz.Quiz;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class QuizSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String submissionDateAndTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne
    private Grade grade;

    public QuizSubmission(String submissionDateAndTime, Quiz quiz) {
        this.submissionDateAndTime = submissionDateAndTime;
        this.quiz = quiz;
    }

}
