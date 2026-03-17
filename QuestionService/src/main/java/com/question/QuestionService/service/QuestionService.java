package com.question.QuestionService.service;

import java.util.List;

import com.question.QuestionService.dto.QuestionDto;

public interface QuestionService {

    public List<QuestionDto> getAllQuestions();

    public QuestionDto getQuestionById(Long id);

    public QuestionDto addNewQuestion(QuestionDto questionDto);

    public List<QuestionDto> getQuestionByQuizId(Long quizId);

}
