package org.englishapp.programm.service;

import org.englishapp.programm.entity.Category;
import org.englishapp.programm.entity.Word;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(long theId);

    void save(Category theCategory);

    void deleteById(long theId);

}
