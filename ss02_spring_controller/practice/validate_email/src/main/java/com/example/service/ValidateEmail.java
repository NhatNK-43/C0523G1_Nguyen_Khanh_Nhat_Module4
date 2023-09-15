package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ValidateEmail {
    public boolean validateEmail(String email, String regexEmail){
        return email.matches(regexEmail);
    }
}
