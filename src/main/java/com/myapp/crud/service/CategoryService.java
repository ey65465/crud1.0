package com.myapp.crud.service;

import com.myapp.crud.pojo.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void delete(int id);
    void update(Category category);
    Category get(int id);
    List<Category> list();
}
