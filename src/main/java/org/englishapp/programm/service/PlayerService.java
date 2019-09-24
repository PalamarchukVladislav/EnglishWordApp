package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;

import java.util.List;

public interface PlayerService {

    List<Category> getCategoriesForPlay();

    Category findCategoriesForPlayById(long theId);

}
