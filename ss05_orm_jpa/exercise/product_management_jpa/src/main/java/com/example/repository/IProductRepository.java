package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    Product findById(int id);
    List<Product> findAll();
    boolean create(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
    List<Product> showListSearch(String name);
}
