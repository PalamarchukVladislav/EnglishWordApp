package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.response.CategoryResponse;
import org.englishapp.programm.repository.CategoryRepository;
import org.englishapp.programm.repository.PlayerRepository;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private long findRandomIdForWord(long categoryId){

        Category category = categoryRepository.getOne(categoryId);

        List<Word> words = category.getWords();
        long minValueForRandom = words.get(0).getId();
        long maxValueForRandom = words.size();

        Random random = new Random();

        return minValueForRandom + random.nextInt((int) (maxValueForRandom - minValueForRandom + 1));
    }

}
