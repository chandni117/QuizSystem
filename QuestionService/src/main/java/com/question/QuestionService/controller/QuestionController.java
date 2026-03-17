package com.question.QuestionService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.dto.QuestionDto;
import com.question.QuestionService.service.QuestionService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id)).getBody();
    }

    @PostMapping
    public QuestionDto addNewQuestion(@RequestBody QuestionDto questionDto) {
        
        return ResponseEntity.ok(questionService.addNewQuestion(questionDto)).getBody();
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<List<QuestionDto>> getQuestionByQuizId(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionByQuizId(id));
    }
    
    
    
    


}
