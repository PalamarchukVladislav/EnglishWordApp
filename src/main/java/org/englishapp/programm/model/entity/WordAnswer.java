package org.englishapp.programm.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
public class WordAnswer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long wordId;

    @Column(name = "ukr_answer_translate")
    private String ukrAnswerTranslate;

}
