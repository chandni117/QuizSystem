package com.quiz.QuizService.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.QuizService.entity.Question;

@FeignClient(name="QUESTIONSERVICE" )
public interface QuestionClient {

    @GetMapping("/question/quiz/{id}")
    List<Question> getQuestionOfQuiz(@PathVariable Long id);

}
