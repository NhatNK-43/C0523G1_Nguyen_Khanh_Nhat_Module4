package com.example.blog_category.repository;

import com.example.blog_category.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BlogEntity, Integer> {

}
