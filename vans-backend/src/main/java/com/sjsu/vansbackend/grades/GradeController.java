package com.sjsu.vansbackend.grades;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeController {

        private final GradeService gradeService;

        public GradeController(GradeService gradeService) {
            this.gradeService = gradeService;
        }

        @GetMapping("/add")
        public Grade addGrade(Grade grade) {
            return gradeService.addGrade(grade);
        }

        @GetMapping("/update")
        public void updateGrade(Grade grade) {
            gradeService.updateGrade(grade);
        }



        @GetMapping("/{gradeId}")
        public Grade getGradeById(@PathVariable Integer gradeId) {
            return gradeService.getGradeById(gradeId);
        }

    @GetMapping("/{assignmentSubmissionId}")
    public Grade getGradeByAssignmentSubmissionId(@PathVariable Integer assignmentSubmissionId) {
        return gradeService.getGradeByAssignmentSubmissionId(assignmentSubmissionId);
    }

    @GetMapping("/{quizSubmissionId}")
    public Grade getGradeByQuizSubmissionId(@PathVariable Integer quizSubmissionId) {
        return gradeService.getGradeByQuizSubmissionId(quizSubmissionId);
    }
}
