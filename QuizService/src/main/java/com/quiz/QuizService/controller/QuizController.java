package com.quiz.QuizService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.dto.QuizDto;
import com.quiz.QuizService.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllQuiz() {
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @GetMapping("/{id}")
    public QuizDto getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id)).getBody();
    }

    @PostMapping
    public QuizDto addNewQuiz(@RequestBody QuizDto questionDto) {
        
        return ResponseEntity.ok(quizService.addNewQuiz(questionDto)).getBody();
    }
    


}
