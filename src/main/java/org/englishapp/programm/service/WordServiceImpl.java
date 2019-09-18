package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
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
    public void save(WordRequest wordRequest) {
        Word word = createWordFromWordRequest(wordRequest);
        Category category = categoryService.findById(wordRequest.getCategoryId());
        category.addWord(word);
        wordRepository.save(word);
    }

    @Override
    public void deleteById(long wordId) {
        wordRepository.deleteById(wordId);
    }

    private Word createWordFromWordRequest(WordRequest wordRequest){
        Word word = new Word();
        word.setUkrTranslate(wordRequest.getUkrTranslate());
        word.setEngTranslate(wordRequest.getEngTranslate());
        return word;
    }

}
