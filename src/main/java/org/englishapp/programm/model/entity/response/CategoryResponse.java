package org.englishapp.programm.model.entity.response;

import lombok.Data;
import org.englishapp.programm.model.entity.Word;

@Data
public class CategoryResponse {

    private long id;

    private String categoryName;

    public void addWord(Word word) {
    }
}
