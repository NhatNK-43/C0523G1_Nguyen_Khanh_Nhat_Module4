package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.xml.ws.Action;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
//        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Create successfully!");
        return "redirect:/";
    }

    @GetMapping("/form-update")
    public String showFormUpdate(@RequestParam int id, Model model){
        System.out.println(id);
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "update";
    }
    @GetMapping("/update")
    public String update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
//        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Update successfully!");
        return "redirect:/";
    }
}
