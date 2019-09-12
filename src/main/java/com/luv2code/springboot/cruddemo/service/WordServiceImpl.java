package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Word;
import com.luv2code.springboot.cruddemo.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }


    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @Override
    public Word findById(int wordId) {

        Optional<Word> result = wordRepository.findById(wordId);

        Word word = null;

        if (result.isPresent()){
            word = result.get();
        }else {
            throw new RuntimeException("Did not find category id - " + wordId );
        }

        return word;
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteById(int wordId) {
        wordRepository.deleteById(wordId);
    }
}
