package com.example.blog_category.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<BlogEntity> blogSet;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String name, Set<BlogEntity> blogSet) {
        this.id = id;
        this.name = name;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogEntity> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<BlogEntity> blogSet) {
        this.blogSet = blogSet;
    }
}
