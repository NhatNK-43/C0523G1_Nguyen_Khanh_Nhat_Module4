package com.example.song.service;

import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    boolean save(Song song);
}
