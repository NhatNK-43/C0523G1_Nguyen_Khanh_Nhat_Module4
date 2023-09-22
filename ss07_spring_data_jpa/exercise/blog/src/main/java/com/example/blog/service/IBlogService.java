package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog findById(int id);
    List<Blog> findAll();
    List<Blog> findAllByTitleContaining(Pageable pageable, String title);
    boolean save(Blog blog);
    boolean delete(int id);
}
