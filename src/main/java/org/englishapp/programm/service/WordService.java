package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
import org.englishapp.programm.model.entity.response.WordResponse;

import java.util.List;

public interface WordService  {

     List<WordResponse> findAll(WordRequest wordRequest);

     WordResponse findById(long wordId);

     WordResponse save(WordRequest wordRequest);

     void deleteById(long wordId);
}
