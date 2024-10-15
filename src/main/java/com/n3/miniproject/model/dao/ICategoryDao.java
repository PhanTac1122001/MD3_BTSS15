package com.n3.miniproject.model.dao;

import com.n3.miniproject.model.entity.Book;
import com.n3.miniproject.model.entity.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();

    Category findById(int id);
    boolean addCate(Category category);
    boolean updateCate(Category category);
    void  deleteCate(int id);
}
