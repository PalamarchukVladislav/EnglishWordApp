package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final CategoryService categoryService;

    WordServiceImpl(WordRepository wordRepository, CategoryService categoryService){
        this.wordRepository = wordRepository;
        this.categoryService = categoryService;
    }


    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @Override
    public Word findById(long wordId) {

        Optional<Word> wordOptional = wordRepository.findById(wordId);

        Word word;

        if (wordOptional.isPresent()){
            word = wordOptional.get();
        }else {
            throw new RuntimeException("Word with " + wordId + " id, not found" );
        }

        return word;
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteById(long wordId) {
        wordRepository.deleteById(wordId);
    }


}
