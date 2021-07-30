package com.myapp.crud.service.impl;

import com.myapp.crud.mapper.ProductMapper;
import com.myapp.crud.pojo.Product;
import com.myapp.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public void delete(int id) {
        productMapper.delete(id);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    @Override
    public Product get(int id) {
        return productMapper.get(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.list();
    }

    @Override
    public List<Product> listByCid(int id) {
        return productMapper.listByCid(id);
    }
}
