package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.service.CategoryService;
import org.englishapp.programm.service.PlayerService;
import org.englishapp.programm.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private CategoryService categoryService;
    private WordService wordService;

    public PlayerController(PlayerService playerService, CategoryService categoryService, WordService wordService){
        this.playerService = playerService;
        this.categoryService = categoryService;
        this.wordService = wordService;
    }

    @GetMapping("/showAllCategories")
    public List<Category> findAllCategoriesForPlay(){

        return playerService.findCategoriesForPlay();
    }

    @GetMapping("/showAllCategories/{categoriesId}")
    public Category findCategoryForPlay(@PathVariable long categoriesId){

        return playerService.findCategoriesForPlayById(categoriesId);
    }

    @GetMapping("/randomWordFormCategory/{categoriesId}")
    public Word getRandomWordForPlayByCategoryId(@PathVariable long categoriesId){

        return playerService.findRandomWordForPlayByCategoryId(categoriesId);
    }
}
