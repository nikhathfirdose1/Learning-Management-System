package com.sjsu.vansbackend.quizSubmissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz-submissions")
public class QuizSubController {

    private final QuizSubService quizSubService;

    public QuizSubController(QuizSubService quizSubService) {
        this.quizSubService = quizSubService;
    }

    // Retrieve (GET Request)
    @GetMapping("/add")
    public QuizSubmission addQuizSubmission(QuizSubmission quizSubmission) {
        return quizSubService.addQuizSubmission(quizSubmission);
    }

    @GetMapping("/update")
    public void updateQuizSubmission(QuizSubmission quizSubmission) {
        quizSubService.updateQuizSubmission(quizSubmission);
    }

    @GetMapping("/{quizSubmissionId}")
    public QuizSubmission getQuizSubmissionById(@PathVariable Integer quizSubmissionId) {
        return quizSubService.getQuizSubmissionById(quizSubmissionId);
    }
    @GetMapping("/list/{quizId}")
    public List<QuizSubmission> getQuizSubmissionsByQuizId(@PathVariable Integer quizId) {
        return quizSubService.getQuizSubmissionsByQuizId(quizId);
    }

}
