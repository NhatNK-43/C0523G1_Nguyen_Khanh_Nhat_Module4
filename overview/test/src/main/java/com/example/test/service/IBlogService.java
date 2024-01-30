package com.example.test.service;

import com.example.test.model.Blog;

import java.util.List;

public interface IBlogService{
    List<Blog> findAll();
    List<Blog> getAll();
    void save(Blog blog);
    void deleteById(int id);
}
