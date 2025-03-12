package com.harshit.CoadingQuiz.entity;

import com.mysql.cj.protocol.ColumnDefinition;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class QuizQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String questionText;
    private String correctAnswer;


    @ElementCollection      //internal class k andr jb doosre class ki mapping dete hai tb @ElementCollection use krte hai;
    @CollectionTable(name = "question_options",joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text")
    private List<String> options;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
