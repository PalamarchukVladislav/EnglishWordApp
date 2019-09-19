package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.request.CategoryRequest;
import org.englishapp.programm.model.entity.response.CategoryResponse;
import org.englishapp.programm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryResponse> findAll(CategoryRequest categoryRequest) {

        CategoryResponse categoryResponse;

        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new LinkedList<>();

        if (categories != null){

            for (int i = 0; i < categories.size(); i++) {
                categoryResponse = categoryToCategoryResponse(categories.get(i));
                categoryResponses.add(i,categoryResponse);
            }

        } else {
            throw new RuntimeException("We not have ony words" );
        }

        return categoryResponses;
    }

    @Override
    public CategoryResponse findById(long categoriesId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoriesId);

        Category category;

        if (categoryOptional.isPresent()){
            category = categoryOptional.get();
        }else {
            throw new RuntimeException("Did not find category id - " + categoriesId );
        }

        return categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {

        Category category = createCategoryFromCategoryRequest(categoryRequest);
//        WordResponse wordResponse = wordService.findById(categoryRequest.getId());
////        wordResponse.addCategory(category);
        categoryRepository.save(category);

        return categoryToCategoryResponse(category);
    }

    @Override
    public void deleteById(long categoriesId) {
        categoryRepository.deleteById(categoriesId);
    }


    private Category createCategoryFromCategoryRequest(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        return category;
    }

    private CategoryResponse categoryToCategoryResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryName(category.getCategoryName());

        return categoryResponse;
    }

}
