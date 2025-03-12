package com.harshit.CoadingQuiz.repo;

import com.harshit.CoadingQuiz.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes,String> {
    List<Notes> findByCategory(String category);
}
