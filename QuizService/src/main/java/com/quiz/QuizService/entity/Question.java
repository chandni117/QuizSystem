package com.quiz.QuizService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {

  
    private Long id;

    private String question;

    private Long quizId;

}
