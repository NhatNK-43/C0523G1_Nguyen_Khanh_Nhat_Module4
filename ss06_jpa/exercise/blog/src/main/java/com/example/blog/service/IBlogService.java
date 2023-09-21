package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(int id);
    List<Blog> findAll();
    boolean save(Blog blog);
    boolean delete(int id);
}
