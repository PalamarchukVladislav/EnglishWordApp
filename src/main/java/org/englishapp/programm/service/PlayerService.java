package org.englishapp.programm.service;

import org.englishapp.programm.model.entity.Category;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.WordAnswer;

import java.util.List;

public interface PlayerService {

    List<Category> findCategoriesForPlay();

    Category findCategoriesForPlayById(long theId);

    Word findRandomWordForPlayByCategoryId(long categoryId);

    boolean getAnswer(WordAnswer wordAnswer);

}
