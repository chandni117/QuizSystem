package com.question.QuestionService.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import com.question.QuestionService.dto.QuestionDto;
import com.question.QuestionService.entity.Question;
import com.question.QuestionService.repository.QuestionRepository;
import com.question.QuestionService.service.QuestionService;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;

    
    private final ModelMapper modelMapper;

    public QuestionServiceImplementation(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions
                .stream()
                .map((question) -> new QuestionDto(question.getId(), question.getQuestion(), question.getQuizId()))
                .toList();
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found with id "+ id));
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public QuestionDto addNewQuestion(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        Question q = questionRepository.save(question);
        return modelMapper.map(q, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getQuestionByQuizId(Long quizId) {
        List<Question> questions = questionRepository.getQuestionByQuizId(quizId);
        return questions
                .stream()
                .map((question) -> new QuestionDto(question.getId(), question.getQuestion(), question.getQuizId()))
                .toList();
        
    }

    

}
