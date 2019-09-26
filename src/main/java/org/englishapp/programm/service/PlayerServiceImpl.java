package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.WordAnswer;
import org.englishapp.programm.repository.CategoryRepository;
import org.englishapp.programm.repository.PlayerRepository;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private WordRepository wordRepository;
    private CategoryRepository categoryRepository;

    private WordService wordService;
    PlayerServiceImpl(PlayerRepository playerRepository, WordRepository wordRepository,WordService wordService, CategoryRepository categoryRepository){
        this.playerRepository = playerRepository;
        this.wordRepository = wordRepository;
        this.categoryRepository = categoryRepository;
        this.wordService = wordService;
    }

    private List<Word> GameList(long categoriesId){
        Category category = categoryRepository.getOne(categoriesId);

        return category.getWords();
    }

    @Override
    public List<Category> findCategoriesForPlay() {
        return categoryRepository.findAll();

    }

    @Override
    public Category findCategoriesForPlayById(long categoryId) {
        List<Category> categories = categoryRepository.findAll();

        return categories.get((int) categoryId);
    }

    @Override
    public Word findRandomWordForPlayByCategoryId(long categoryId) {
        return wordRepository.getOne(findRandomIdForWord(categoryId));
    }

    @Override
    public boolean getAnswer(WordAnswer wordAnswer) {

        boolean answer = false;

        Word truWord = wordRepository.getOne(wordAnswer.getWordId());

        if (truWord.getUkrTranslate().equals(wordAnswer.getUkrAnswerTranslate())){
            answer = true;
            GameList(truWord.getCategory().getId()).remove(truWord);
        }else if (!truWord.getUkrTranslate().equals(wordAnswer.getUkrAnswerTranslate())){
            answer = false;
        }

        return answer;
    }


    private long findRandomIdForWord(long categoryId){
        long minValueForRandom = GameList(categoryId).get(0).getId();
        long maxValueForRandom = GameList(categoryId).size();

        Random random = new Random();

        return minValueForRandom + random.nextInt((int) maxValueForRandom);
    }


}
