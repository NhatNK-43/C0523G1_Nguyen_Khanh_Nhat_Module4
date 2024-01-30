package com.example.blog_category.service.impl;

import com.example.blog_category.model.BlogEntity;
import com.example.blog_category.repository.IBlogRepository;
import com.example.blog_category.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<BlogEntity> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public BlogEntity findById(int id) {
        return blogRepository.findById(id).get();
    }
}
