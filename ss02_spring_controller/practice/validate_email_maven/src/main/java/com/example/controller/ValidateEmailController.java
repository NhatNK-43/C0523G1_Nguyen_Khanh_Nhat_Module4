package com.example.controller;

import com.example.service.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateEmailController {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @Autowired
    private ValidateEmail validateEmail;

    @GetMapping("")
    public String showFormEmail() {
        return "validate-email";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam String inputEmail, Model model) {
        String message;
        if (validateEmail.validateEmail(inputEmail, REGEX_EMAIL)) {
            message = "The email is valid";
        } else {
            message = "The email is invalid!";
        }
        model.addAttribute("inputEmail", inputEmail);
        model.addAttribute("message", message);
        return "validate-email";
    }
}
