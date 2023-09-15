package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String save(){
        return "index";
    }
    @PostMapping("/save")
    public String resultSandwich(@RequestParam(required = false) String lettuce,
                                 @RequestParam(required = false) String tomato,
                                 @RequestParam(required = false) String mustard,
                                 @RequestParam(required = false) String sprouts,
                                 Model model){
        String[] condiments = {lettuce,tomato,mustard,sprouts};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<condiments.length;i++){
            if(condiments[i]!=null){
                result.append(condiments[i]).append(", ");
            }
        }
        model.addAttribute("result", result.toString());
        return "index";
    }
}
