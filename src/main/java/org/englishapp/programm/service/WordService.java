package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;

import java.util.List;

public interface WordService  {

    public List<Word> findAll();

    public Word findById(long wordId);

    public void save(WordRequest wordRequest);

    public void deleteById(long wordId);

}
