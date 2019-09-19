package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.service.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    } // Dependency injection

    @GetMapping("/list")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/list/{categoriesId}")
    public Category getCategory(@PathVariable long categoriesId){

        Category category = categoryService.findById(categoriesId);

        if (category == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        return category;
    }

    @PostMapping("/list")
    public Category addCategory(@RequestBody Category category){

        categoryService.save(category);

        return category;
    }

    @PutMapping("/list")
    public Category updateCategory(@RequestBody Category category){

        categoryService.save(category);

        return category;
    }

    @DeleteMapping("/list/{categoriesId}")
    public String deleteCategory(@PathVariable long categoriesId){

        Category category = categoryService.findById(categoriesId);

        if (category == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        categoryService.deleteById(categoriesId);

        return "Deleted category id - " + categoriesId;
    }

}
