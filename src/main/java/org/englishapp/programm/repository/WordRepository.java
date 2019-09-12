package org.englishapp.programm.repository;

import org.englishapp.programm.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
