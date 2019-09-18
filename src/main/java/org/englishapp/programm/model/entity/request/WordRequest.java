package org.englishapp.programm.model.entity.request;

import lombok.Data;


@Data
public class WordRequest {

    private String engTranslate;

    private String ukrTranslate;

    private Long categoryId;
}
