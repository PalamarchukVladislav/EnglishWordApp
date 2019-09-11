package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public Category findById(int theId);

    public void save(Category theCategory);

    public void deleteById(int theId);
}
