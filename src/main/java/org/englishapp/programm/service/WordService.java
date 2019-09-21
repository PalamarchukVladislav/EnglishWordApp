package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Word;

import java.util.List;

public interface WordService  {

    public List<Word> findAll();

    public Word findById(long wordId);

    public void save(Word word);

    public void deleteById(long wordId);

}
