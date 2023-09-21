package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date dateOfWriting;
    private String pathImg;

    public Blog() {

    }

    public Blog(int id, String title, String content, Date dateOfWriting, String pathImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateOfWriting = dateOfWriting;
        this.pathImg = pathImg;
    }

    public Date getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(Date dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
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
}
