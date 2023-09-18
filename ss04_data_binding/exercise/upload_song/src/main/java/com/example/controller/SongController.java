package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<Song> songList = songService.showList();
        model.addAttribute("songList",songList);
        return "list";
    }
}
