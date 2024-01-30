package com.example.pig_management.service;

import com.example.pig_management.model.Pig;

import java.util.List;

public interface IPigService {
    List<Pig> findAll();
    List<Pig> searchPig(String isSold, String pigCode, String idOrigin);
    Pig findById(int id);
    boolean deletePigById(int id);
}
