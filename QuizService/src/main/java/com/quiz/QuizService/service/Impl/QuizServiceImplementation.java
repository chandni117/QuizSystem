package com.quiz.QuizService.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.quiz.QuizService.dto.QuizDto;
import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import com.quiz.QuizService.service.QuestionClient;
import com.quiz.QuizService.service.QuizService;

@Service

public class QuizServiceImplementation implements QuizService{
    private final QuizRepository quizRepository;

    private final ModelMapper modelMapper;

    private final QuestionClient questionClient;

    public QuizServiceImplementation(QuizRepository quizRepository, ModelMapper modelMapper, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.questionClient = questionClient;
    }

    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> quizs = quizRepository.findAll();

        List<Quiz> newQuizList = quizs
                .stream()
                .map((quiz) -> {
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                return quiz;
    }).collect(Collectors.toList());
                

        return newQuizList
                .stream()
                .map((quiz) -> new QuizDto(quiz.getId(), quiz.getQuiz(), quiz.getQuestions()))
                .toList();
    }

    @Override
    public QuizDto getQuizById(Long id) {
          Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found with id "+ id));
          quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return modelMapper.map(quiz, QuizDto.class);
    }

    @Override
    public QuizDto addNewQuiz(QuizDto quizDto) {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        Quiz q = quizRepository.save(quiz);
        return modelMapper.map(q, QuizDto.class);
    }

    

   

}


