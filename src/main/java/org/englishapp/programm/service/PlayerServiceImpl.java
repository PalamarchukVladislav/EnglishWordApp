package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.response.CategoryResponse;
import org.englishapp.programm.repository.CategoryRepository;
import org.englishapp.programm.repository.PlayerRepository;
import org.englishapp.programm.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public List<Category> getCategoriesForPlay() {
        List<Category> categories = categoryRepository.findAll();

        return categories;

    }

    @Override
    public Category findCategoriesForPlayById(long categoryId) {

        List<Category> categories = categoryRepository.findAll();

        return categories.get((int) categoryId);
    }

//    private CategoryResponse fromCategoryToCategoryResponse(Category category){
//        CategoryResponse categoryResponse = new CategoryResponse();
//        categoryResponse.setCategoryName(category.getCategoryName());
//
//        return categoryResponse;
//    }
}
