package com.prasad.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.quizapp.entity.QuestionWrapper;
import com.prasad.quizapp.entity.Response;
import com.prasad.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

        @Autowired
        QuizService quizService;
	
    @PostMapping("create") 
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numq, @RequestParam  String title ){
	   return quizService.createQuiz(category,numq,title);
	
	}

    @GetMapping("get/{id}") 
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
     return quizService.getQuizquestions(id);
    }
    
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
    return quizService.calculateResult(id,responses);

}

}

