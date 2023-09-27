package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String singer;
    private String musicGenre;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String musicGenre) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (("").equals(songDto.getName())) {
            errors.rejectValue("name", null, "Bạn chưa nhập tên bài hát!");
        } else if (!songDto.getName().matches("^[A-Za-z0-9\\s]{1,800}$")){
            errors.rejectValue("name",null,"Tên bài hát không chưa ký tự đặc biệt và có ít hơn 800 ký tự!");
        }

        if (("").equals(songDto.getSinger())) {
            errors.rejectValue("singer", null, "Bạn chưa nhập tên người thể hiện !");
        } else if (!songDto.getSinger().matches("^[A-Za-z0-9\\s]{1,300}$")){
            errors.rejectValue("singer",null,"Tên người thể hiện không chưa ký tự đặc biệt và có ít hơn 300 ký tự!");
        }

        if (("").equals(songDto.getMusicGenre())) {
            errors.rejectValue("musicGenre", null, "Bạn chưa nhập thể loại bài hát!");
        } else if (!songDto.getMusicGenre().matches("[A-Za-z]+(,?\\s?[A-Za-z]+)*")){
            errors.rejectValue("musicGenre",null,"Tên thể loại bài hát chưa hợp lệ!");
        }

    }
}
