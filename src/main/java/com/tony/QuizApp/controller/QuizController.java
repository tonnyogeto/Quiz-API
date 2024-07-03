package com.tony.QuizApp.controller;

import com.tony.QuizApp.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController{
    public ResponseEntity<String> createQuiz(@RequestParam String category@RequestParam int numQ @RequestParam String title){

        @AutoWired
        QuizService quizService;
        return quizService.
    }
}

