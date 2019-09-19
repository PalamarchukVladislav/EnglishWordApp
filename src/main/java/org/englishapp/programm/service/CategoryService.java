package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.request.CategoryRequest;
import org.englishapp.programm.model.entity.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll(CategoryRequest categoryRequest);

    CategoryResponse findById(long theId);

    CategoryResponse save(CategoryRequest categoryRequest);

    void deleteById(long theId);

}
