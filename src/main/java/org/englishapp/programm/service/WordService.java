package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
import org.englishapp.programm.model.entity.response.WordResponse;

import java.util.List;

public interface WordService  {

    public List<WordResponse> findAll();

    public WordResponse findById(long wordId);

    public void save(WordRequest wordRequest);

    public void deleteById(long wordId);

}
