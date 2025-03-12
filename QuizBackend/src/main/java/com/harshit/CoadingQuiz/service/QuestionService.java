package com.harshit.CoadingQuiz.service;

import com.harshit.CoadingQuiz.entity.Notes;
import com.harshit.CoadingQuiz.entity.QuizQuestions;
import com.harshit.CoadingQuiz.repo.NotesRepository;
import com.harshit.CoadingQuiz.repo.QuestionRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    private NotesRepository notesRepository;

    public List<QuizQuestions> getAllQuestions() {

        List<QuizQuestions> questionRepoAll = questionRepo.findAll();
        return questionRepoAll;
    }

    public List<QuizQuestions> getQuestionsByCategory(String category) {
        List<QuizQuestions>categoryWise =  questionRepo.findByCategory(category);
        return categoryWise;
    }

    public QuizQuestions saveQuestion(QuizQuestions question) {

        QuizQuestions save = questionRepo.save(question);
        return save;
    }

    public List<Notes> getNotesByCategory(String category){
        return notesRepository.findByCategory(category);
    }

    public Notes saveNote(Notes notes){
        return notesRepository.save(notes);
    }




}
