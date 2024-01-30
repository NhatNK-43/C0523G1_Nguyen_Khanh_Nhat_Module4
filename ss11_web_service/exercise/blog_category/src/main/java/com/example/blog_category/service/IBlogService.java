package com.example.blog_category.service;

import com.example.blog_category.model.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogEntity> findAll(Pageable pageable);
    BlogEntity findById(int id);
}
