package com.example.test.dto;

import com.example.test.model.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class BlogDto {
    private int id;
    @NotBlank(message = "không được để trống")

    private String title;
    @NotBlank(message = "không được để trống")
    private String content;
    @NotBlank(message = "không được để trống")
    private Date dateWriting;
    @NotBlank(message = "không được để trống")
    private String Writer;
    @NotBlank(message = "không được để trống")
    private boolean deleted;
    @NotBlank(message = "không được để trống")
    private Category category;

    public BlogDto() {
    }

    public BlogDto(String title, String content, Date dateWriting, String writer, boolean deleted, Category category) {
        this.title = title;
        this.content = content;
        this.dateWriting = dateWriting;
        Writer = writer;
        this.deleted = deleted;
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

    public Date getDateWriting() {
        return dateWriting;
    }

    public void setDateWriting(Date dateWriting) {
        this.dateWriting = dateWriting;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
