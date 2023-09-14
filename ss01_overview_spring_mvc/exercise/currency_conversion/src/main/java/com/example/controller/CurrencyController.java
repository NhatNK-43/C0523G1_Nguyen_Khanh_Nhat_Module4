package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/currency")
    public String showFormConvert(){
        return "currency-conversion";
    }

    @PostMapping("/currency")
    public String convert(@RequestParam String usd, Model model){
        double vnd = Double.parseDouble(usd) * 24000;
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "currency-conversion";
    }
}
