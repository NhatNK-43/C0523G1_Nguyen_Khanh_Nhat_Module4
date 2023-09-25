package com.example.register_form.service;

import com.example.register_form.model.User;
import com.example.register_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public boolean save(User user) {
        try{
            iUserRepository.save(user);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
