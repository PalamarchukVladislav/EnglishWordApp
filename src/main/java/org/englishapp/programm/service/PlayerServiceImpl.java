package org.englishapp.programm.service;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final WordRepository wordRepository;
    private final CategoryRepository categoryRepository;
    private final WordService wordService;

    private List<Word> playList = new ArrayList<>();

    private List<Word> GameList(long categoriesId){
        Category category = categoryRepository.getOne(categoriesId);

        playList.addAll(category.getWords());

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

        Word originalWord = wordRepository.getOne(wordAnswer.getWordId());

        if (originalWord.getUkrTranslate().equals(wordAnswer.getUkrAnswerTranslate())) {
            playList.remove(originalWord);
            return true;
        } else {
            return false;
        }
    }


    private long findRandomIdForWord(long categoryId){
        long minValueForRandom = GameList(categoryId).get(0).getId();
        long maxValueForRandom = GameList(categoryId).size();

        Random random = new Random();

        return minValueForRandom + random.nextInt((int) maxValueForRandom);
    }


}
