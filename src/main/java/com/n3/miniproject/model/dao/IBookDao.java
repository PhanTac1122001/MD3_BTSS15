package com.n3.miniproject.model.dao;

import com.n3.miniproject.model.entity.Book;
import com.n3.miniproject.model.entity.Category;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();

    Book findById(int id);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    void  deleteBook(int id);
}
