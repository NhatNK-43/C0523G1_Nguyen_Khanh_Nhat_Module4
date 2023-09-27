package com.example.library.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_code", columnDefinition = "int not null")
    private int bookCode;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public BookCode() {
    }

    public BookCode(int bookCode, Book book) {
        this.bookCode = bookCode;
        this.book = book;
    }

    public BookCode(int id, int bookCode, Book book) {
        this.id = id;
        this.bookCode = bookCode;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int code) {
        this.bookCode = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
