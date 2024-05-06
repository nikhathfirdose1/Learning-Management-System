package com.sjsu.vansbackend.quizSubmissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizSubService {

    @Autowired
    QuizSubRepository quizSubRepository;

    public QuizSubmission addQuizSubmission(QuizSubmission quizSubmission) {
        return quizSubRepository.save(quizSubmission);
    }

    public void updateQuizSubmission(QuizSubmission quizSubmission) {
        quizSubRepository.save(quizSubmission);
    }

    public void deleteQuizSubmission(Integer quizSubmissionId) {
        quizSubRepository.deleteById(quizSubmissionId);
    }

    public QuizSubmission getQuizSubmissionById(Integer quizSubmissionId) {
        return quizSubRepository.findById(quizSubmissionId).orElse(null);
    }

    public List<QuizSubmission> getQuizSubmissionsByQuizId(Integer quizId) {
        return quizSubRepository.findByQuizId(quizId);
    }

}
