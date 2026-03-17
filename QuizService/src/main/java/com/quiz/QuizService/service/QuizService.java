package com.quiz.QuizService.service;

import java.util.List;

import com.quiz.QuizService.dto.QuizDto;

public interface QuizService {


    public List<QuizDto> getAllQuiz();

    public QuizDto getQuizById(Long id);

    public QuizDto addNewQuiz(QuizDto questionDto);

}
