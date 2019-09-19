package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.request.CategoryRequest;
import org.englishapp.programm.model.entity.response.CategoryResponse;
import org.englishapp.programm.service.CategoryService;
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
    public List<CategoryResponse> findAll(CategoryRequest categoryRequest){
        return categoryService.findAll(categoryRequest);
    }

    @GetMapping("/list/{categoriesId}")
    public CategoryResponse getCategory(@PathVariable long categoriesId){

        CategoryResponse categoryResponse = categoryService.findById(categoriesId);

        if (categoryResponse == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        return categoryResponse;
    }

    @PostMapping("/list")
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest){

        categoryService.save(categoryRequest);

        return categoryService.save(categoryRequest);
    }

    @PutMapping("/list")
    public CategoryResponse updateCategory(@RequestBody CategoryRequest categoryRequest){

        categoryService.save(categoryRequest);

        return categoryService.save(categoryRequest);
    }

    @DeleteMapping("/list/{categoriesId}")
    public String deleteCategory(@PathVariable long categoriesId){

        CategoryResponse categoryResponse = categoryService.findById(categoriesId);

        if (categoryResponse == null){
            throw new RuntimeException("Category id not found - " + categoriesId);
        }

        categoryService.deleteById(categoriesId);

        return "Deleted category id - " + categoriesId;
    }

}
