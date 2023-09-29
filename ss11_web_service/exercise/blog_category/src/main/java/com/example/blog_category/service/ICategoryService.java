package com.example.blog_category.service;

import com.example.blog_category.model.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryEntity> findAll();
}
