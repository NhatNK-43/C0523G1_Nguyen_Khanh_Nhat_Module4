package com.example.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(100) not null")
    private String name;
    @Column(name = "amount", columnDefinition = "int default 0")
    private int amount;

    @Column(name = "path")
    private String path;

    @OneToMany(mappedBy = "book")
    private Set<BookCode> bookCodeSet;

    public Book() {
    }
    public Book(int id, String name, int amount, String path, Set<BookCode> bookCodeSet) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.path = path;
        this.bookCodeSet = bookCodeSet;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<BookCode> getBookCodeSet() {
        return bookCodeSet;
    }

    public void setBookCodeSet(Set<Book> bookSet) {
        this.bookCodeSet = bookCodeSet;
    }
}
