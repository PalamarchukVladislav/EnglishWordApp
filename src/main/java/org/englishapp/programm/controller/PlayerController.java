package org.englishapp.programm.controller;

import lombok.RequiredArgsConstructor;
import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.WordAnswer;
import org.englishapp.programm.service.CategoryService;
import org.englishapp.programm.service.PlayerService;
import org.englishapp.programm.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final CategoryService categoryService;
    private final WordService wordService;


    @GetMapping("/showAllCategories")
    public List<Category> findAllCategoriesForPlay() {
        return playerService.findCategoriesForPlay();
    }

    @GetMapping("/showAllCategories/{categoriesId}")
    public Category findCategoryForPlay(@PathVariable long categoriesId) {
        return playerService.findCategoriesForPlayById(categoriesId);
    }

    @GetMapping("/randomWordFormCategory/{categoriesId}")
    public Word getRandomWordForPlayByCategoryId(@PathVariable long categoriesId) {

        return playerService.findRandomWordForPlayByCategoryId(categoriesId);
    }

    @PostMapping("/answer")
    public boolean sendAnswer(@RequestBody WordAnswer wordAnswer) {

        return playerService.getAnswer(wordAnswer);
    }
}
