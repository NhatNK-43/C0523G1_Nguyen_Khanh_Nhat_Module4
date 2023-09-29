package com.example.blog_category.service;

import com.example.blog_category.model.BlogEntity;

import java.util.List;

public interface IBlogService {
    List<BlogEntity> findAll();
    BlogEntity findById(int id);
}
