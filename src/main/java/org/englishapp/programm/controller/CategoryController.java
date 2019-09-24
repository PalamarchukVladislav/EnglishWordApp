package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
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

    @GetMapping("/list/{categoriesId}")
    public ResponseEntity<Category> getCategory(@PathVariable long categoriesId){

        Category category = categoryService.findById(categoriesId);

        if (category == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        return new ResponseEntity<>(category, HttpStatus.FOUND);
    }

    @PostMapping("/list")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){

        categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/list")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){

        categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/list/{categoriesId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoriesId){

        Category category = categoryService.findById(categoriesId);

        if (category == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        categoryService.deleteById(categoriesId);

        return new ResponseEntity<>("Deleted category id " + categoriesId, HttpStatus.OK);
    }
}
