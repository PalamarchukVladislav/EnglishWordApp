package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(long theId);

    void save(Category category);

    void deleteById(long theId);

}
