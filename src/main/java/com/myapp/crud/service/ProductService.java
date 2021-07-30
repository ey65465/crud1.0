package com.myapp.crud.service;

import com.myapp.crud.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    Product get(int id);
    List<Product> list();
    List<Product> listByCid(int id);
}
