package com.example.controller;

import com.example.service.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private Dictionary dictionary;
    @GetMapping("/dictionary")
    public String showFormTranslateDictionary(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translateDictionary(@RequestParam String englishWord, Model model){
        String result = dictionary.translate(englishWord);
        model.addAttribute("englishWord",englishWord);
        model.addAttribute("result",result);
        return "dictionary";
    }
}
