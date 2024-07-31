package com.tony.QuizApp.controller;


import com.tony.QuizApp.model.Question;
import com.tony.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("category") String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/{questionId}")
    public String updateQuestion(
            @PathVariable("questionId") Integer questionId,
            @RequestBody Question question
    ){
        return questionService.updateQuestion(question, questionId);
    }

    @DeleteMapping("/{questionId}")
    public String deleteProduct(
            @PathVariable("questionId") Integer questionId
    ){
        return questionService.deleteQuestion(questionId);

    }



}
