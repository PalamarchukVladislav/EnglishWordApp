package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.response.CategoryResponse;

import java.util.List;

public interface PlayerService {

    List<CategoryResponse> findAll();

    CategoryResponse findById(long theId);

}
