package com.example.test.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "content", nullable = false, unique = true)
    private String content;

    @Column(name = "dateWriting", nullable = false, columnDefinition = "date")
    private Date dateWriting;

    @Column(name = "writer", nullable = false)
    private String Writer;

    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(String title, String content, Date dateWriting, String writer, boolean deleted, Category category) {
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
