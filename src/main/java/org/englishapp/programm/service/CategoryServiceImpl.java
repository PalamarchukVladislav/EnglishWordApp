package org.englishapp.programm.service;

import org.englishapp.programm.entity.Category;
import org.englishapp.programm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long categoriesId) {
        Optional<Category> result = categoryRepository.findById(categoriesId);

        Category category = null;

        if (result.isPresent()){
            category = result.get();
        }else {
            throw new RuntimeException("Did not find category id - " + categoriesId );
        }

        return category;
    }

    @Override
    public void save(Category category) {

        categoryRepository.save(category);

    }

    @Override
    public void deleteById(long categoriesId) {
        categoryRepository.deleteById(categoriesId);
    }
}
