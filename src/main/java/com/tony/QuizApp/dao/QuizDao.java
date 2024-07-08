package com.tony.QuizApp.dao;

import com.tony.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
