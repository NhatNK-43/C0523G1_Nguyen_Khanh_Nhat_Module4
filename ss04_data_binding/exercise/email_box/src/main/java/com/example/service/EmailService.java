package com.example.service;

import com.example.model.Email;
import com.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public List<Email> getAll() {
        return emailRepository.getAll();
    }

    @Override
    public Email getEmailById(int id) {
        return emailRepository.getEmailById(id);
    }

    @Override
    public void update(int idUpdate, Email email) {
        emailRepository.update(idUpdate,email);
    }
}
