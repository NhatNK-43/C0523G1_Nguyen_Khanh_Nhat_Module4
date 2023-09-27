package com.example.song.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(800) not null")
    private String name;
    @Column(name = "singer", columnDefinition = "varchar(300) not null")
    private String singer;
    @Column(name = "music_genre", columnDefinition = "varchar(100) not null")
    private String musicGenre;

    public Song() {
    }

    public Song(int id, String name, String singer, String musicGenre) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.musicGenre = musicGenre;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
