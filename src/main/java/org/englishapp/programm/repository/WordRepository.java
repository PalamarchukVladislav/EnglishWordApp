package org.englishapp.programm.repository;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.response.WordResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
}
