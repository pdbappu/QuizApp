package com.prasad.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasad.quizapp.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
