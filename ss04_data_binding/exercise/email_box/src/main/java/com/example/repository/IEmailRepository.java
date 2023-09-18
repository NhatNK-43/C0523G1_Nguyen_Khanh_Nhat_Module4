package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface IEmailRepository {
    public List<Email> getAll();
    Email getEmailById(int id);
    void update(int idUpdate, Email email);
}
