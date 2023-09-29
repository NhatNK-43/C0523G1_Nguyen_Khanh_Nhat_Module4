package com.example.blog_category.dto;

import com.example.blog_category.model.CategoryEntity;

public class BlogDto {
    private int id;
    private String title;
    private String content;
    private CategoryEntity category;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String content, CategoryEntity category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
