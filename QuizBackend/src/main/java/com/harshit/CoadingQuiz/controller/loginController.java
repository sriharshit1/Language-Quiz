package com.harshit.CoadingQuiz.controller;

import com.harshit.CoadingQuiz.dto.LoginRequest;
import com.harshit.CoadingQuiz.entity.Notes;
import com.harshit.CoadingQuiz.entity.QuizQuestions;
import com.harshit.CoadingQuiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class loginController {

    @Autowired
    QuestionService questionService;
    private final String USERNAME = "user";
    private  final String PASSWORD = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest)
    {
        if(USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword()))
        {
            return "Login Successfully";
        }
        else
        {
            return "Invalid username or password";
        }
    }
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    @GetMapping("/questions/{category}")
    public List<QuizQuestions> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping(value = "/save",consumes = "application/json",produces = "application/json")
    public QuizQuestions saveQuestion(@RequestBody QuizQuestions question)
    {
        QuizQuestions saved = questionService.saveQuestion(question);
        return saved;
    }
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    @GetMapping("/notes/{category}")
    public List<Notes> getNotesByCategory(@PathVariable String category){
        return questionService.getNotesByCategory(category);
    }
    @PostMapping("/notes/{category}")
    public Notes saveNotes(@RequestBody Notes notes){
        return questionService.saveNote(notes);
    }

}
