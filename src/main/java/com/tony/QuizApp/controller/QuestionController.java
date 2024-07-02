package com.tony.QuizApp.controller;


import com.tony.QuizApp.Question;
import com.tony.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable("category") String category){
        return questionService.getQuestionByCategory(category);
    }


    @GetMapping("level/{category}/{level}")
    public List<Question> getQuestionByCategory(@PathVariable("category") String category, @PathVariable("level") String level){
        return questionService.getQuestionByCategoryAndDifficultyLevel(category,level);
    }



    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("{questionId}")
    public String updateQuestion(
            @PathVariable("questionId") Integer questionId,
            @RequestBody Question question
    ){
        return questionService.updateQuestion(question, questionId);
    }

    @DeleteMapping("{questionId}")
    public String deleteProduct(
            @PathVariable("questionId") Integer questionId
    ){
        return questionService.deleteQuestion(questionId);

    }



}
