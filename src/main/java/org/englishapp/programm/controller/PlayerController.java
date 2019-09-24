package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.service.CategoryService;
import org.englishapp.programm.service.PlayerService;
import org.englishapp.programm.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Category>> findAll(){

        List<Category> categories = categoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            List<Category> categoriesAfterCheck = new ArrayList<>(categories);

            return new ResponseEntity<>(categoriesAfterCheck, HttpStatus.FOUND);
        }
    }

    @GetMapping("/showAllCategories/{categoriesId}")
    public ResponseEntity<Category> getCategory(@PathVariable long categoriesId){

        Category category = categoryService.findById(categoriesId);

        if (category == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        return new ResponseEntity<>(category, HttpStatus.FOUND);
    }



}
