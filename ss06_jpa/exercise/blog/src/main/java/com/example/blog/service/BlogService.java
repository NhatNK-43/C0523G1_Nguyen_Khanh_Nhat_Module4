package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean save(Blog blog) {
        try {
            blogRepository.save(blog);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            blogRepository.delete(findById(id));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
