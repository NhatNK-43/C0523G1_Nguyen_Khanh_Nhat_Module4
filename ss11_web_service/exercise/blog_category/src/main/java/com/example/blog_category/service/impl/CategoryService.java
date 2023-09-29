package com.example.blog_category.service.impl;

import com.example.blog_category.model.CategoryEntity;
import com.example.blog_category.repository.ICategoryRepository;
import com.example.blog_category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }
}
