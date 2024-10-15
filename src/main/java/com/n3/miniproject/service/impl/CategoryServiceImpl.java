package com.n3.miniproject.service.impl;

import com.n3.miniproject.model.dao.ICategoryDao;
import com.n3.miniproject.model.entity.Category;
import com.n3.miniproject.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean addCate(Category category) {
        return categoryDao.addCate(category);
    }

    @Override
    public boolean updateCate(Category category) {
        return categoryDao.updateCate(category);
    }

    @Override
    public void deleteCate(int id) {
    categoryDao.deleteCate(id);
    }
}
