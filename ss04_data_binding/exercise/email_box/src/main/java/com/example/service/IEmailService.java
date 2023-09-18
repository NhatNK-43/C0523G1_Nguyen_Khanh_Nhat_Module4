package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface IEmailService {
    public List<Email> getAll();
    Email getEmailById(int id);
    void update(int idUpdate, Email email);
}
