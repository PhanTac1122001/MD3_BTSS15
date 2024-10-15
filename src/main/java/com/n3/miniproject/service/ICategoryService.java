package com.n3.miniproject.service;

import com.n3.miniproject.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);
    boolean addCate(Category category);
    boolean updateCate(Category category);
    void  deleteCate(int id);
}
