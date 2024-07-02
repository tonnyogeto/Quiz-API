package com.tony.QuizApp.service;

import com.tony.QuizApp.Question;
import com.tony.QuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "SUCCESS";
    }

    public String updateQuestion(Question question, Integer questionId) {
        questionDao.save(question);
        return "UPDATED SUCCESSFULLY";
    }

    public String deleteQuestion(Integer questionId) {
        questionDao.deleteById(questionId);
        return "DELETED SUCCESSFULLY";
    }

    public List<Question> getQuestionByCategoryAndDifficultyLevel(String category, String level) {
        return questionDao.findByCategoryAndDifficultyLevel(category,level);
    }
}