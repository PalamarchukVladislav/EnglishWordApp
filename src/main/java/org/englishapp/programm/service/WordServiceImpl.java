package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
import org.englishapp.programm.model.entity.response.WordResponse;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
    public List<WordResponse> findAll(WordRequest wordRequest) {
        WordResponse wordResponse;

        List<Word> words = wordRepository.findAll();
        List<WordResponse> wordResponses = new LinkedList<>();

        if (words != null){

            for (int i = 0; i < words.size(); i++) {
                wordResponse = wordToWordResponse(words.get(i));
                wordResponses.add(i,wordResponse);
            }

        }else {
            throw new RuntimeException("We not have ony words" );
        }




        return wordResponses;
    }

    @Override
    public WordResponse findById(long wordId) {

        Optional<Word> wordOptional = wordRepository.findById(wordId);

        Word word;

        if (wordOptional.isPresent()){
            word = wordOptional.get();
        }else {
            throw new RuntimeException("Word with " + wordId + " id, not found" );
        }

        return wordToWordResponse(word);
    }

    @Override
    public WordResponse save(WordRequest wordRequest) {
        Word word = createWordFromWordRequest(wordRequest);
        Category category = categoryService.findById(wordRequest.getCategoryId());
        category.addWord(word);
        wordRepository.save(word);

        return wordToWordResponse(word);
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

    private WordResponse wordToWordResponse(Word word){
        WordResponse wordResponse = new WordResponse();
        wordResponse.setEngTranslate(word.getEngTranslate());
        wordResponse.setUkrTranslate(word.getUkrTranslate());

        return wordResponse;
    }

}
