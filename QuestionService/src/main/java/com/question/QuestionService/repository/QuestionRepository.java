package com.question.QuestionService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.QuestionService.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

    public List<Question> getQuestionByQuizId(Long quizId);

}
