package com.quiz.QuizService.dto;

import java.util.List;

import com.quiz.QuizService.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {

    private Long id;

    private String quiz;

    private List<Question> questions; 
}
