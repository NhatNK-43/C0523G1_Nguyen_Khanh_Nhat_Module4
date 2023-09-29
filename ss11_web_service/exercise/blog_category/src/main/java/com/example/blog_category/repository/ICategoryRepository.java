package com.example.blog_category.repository;

import com.example.blog_category.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
