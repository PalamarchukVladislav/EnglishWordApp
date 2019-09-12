package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Word;

import java.util.List;

public interface WordService  {

    public List<Word> findAll();

    public Word findById(int wordId);

    public void save(Word word);

    public void deleteById(int wordId);

}
