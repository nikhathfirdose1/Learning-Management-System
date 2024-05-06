package com.sjsu.vansbackend.grades;


import com.sjsu.vansbackend.assignmentSubmissions.AssignmentSubmission;
import com.sjsu.vansbackend.quizSubmissions.QuizSubmission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Grade {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private Integer grade;

        private String feedback;

        @OneToOne
        private AssignmentSubmission assignmentSubmission;

        @OneToOne
        private QuizSubmission quizSubmission;

        public Grade(Integer grade, String feedback) {
            this.grade = grade;
            this.feedback = feedback;
        }

}
