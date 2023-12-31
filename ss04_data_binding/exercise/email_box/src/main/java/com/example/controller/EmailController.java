package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("")
    public String showList(Model model){
        List<Email> emailList = emailService.getAll();
        model.addAttribute("emailList",emailList);
        return "email-box";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model){
        Email email = emailService.getEmailById(id);
        model.addAttribute("languageList",new String[]{"Vietnamese","Chinese", "Japanese","English"});
        model.addAttribute("pageSizeList",new int[]{5, 10, 15, 25, 50, 100});
        model.addAttribute("email",email);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, Model model, RedirectAttributes redirectAttributes){
        emailService.update(email.getId(),email);
        redirectAttributes.addFlashAttribute("mess", "Update successful");
        List<Email> emailList = emailService.getAll();
        model.addAttribute("emailList",emailList);
        return "redirect:/";
    }
}
