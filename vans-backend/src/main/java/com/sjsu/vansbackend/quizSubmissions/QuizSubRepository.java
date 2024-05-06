package com.sjsu.vansbackend.quizSubmissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizSubRepository extends JpaRepository<QuizSubmission, Integer>{

    List<QuizSubmission> findByQuizId(Integer quizId);
}
