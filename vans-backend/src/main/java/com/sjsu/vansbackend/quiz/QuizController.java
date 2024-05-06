package com.sjsu.vansbackend.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/add")
    public Quiz addQuiz(Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/update")
    public Quiz updateQuiz(Quiz quiz) {
        return quizService.updateQuiz(quiz);
    }

    @GetMapping("/delete/{quizId}")
    public void deleteQuiz(Integer quizId) {
        quizService.deleteQuiz(quizId);
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(Integer quizId) {
        return quizService.getQuizById(quizId);
    }

    @GetMapping("/list/{courseId}")
    public Quiz getQuizByCourseId(String courseId) {
        return quizService.getQuizByCourseId(courseId);
    }


}
