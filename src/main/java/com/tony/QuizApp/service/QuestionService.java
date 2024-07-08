package com.tony.QuizApp.service;

import com.tony.QuizApp.model.Question;
import com.tony.QuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>>  getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;

    }


    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }


    public ResponseEntity<String>  addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED ) ;
    }

    public String updateQuestion(Question question, Integer questionId) {
        questionDao.save(question);
        return "UPDATED SUCCESSFULLY";
    }

    public String deleteQuestion(Integer questionId) {
        questionDao.deleteById(questionId);
        return "DELETED SUCCESSFULLY";
    }

}