package com.example.pig_management.service;


import com.example.pig_management.model.Pig;
import com.example.pig_management.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository pigRepository;
    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public List<Pig> searchPig(String isSold, String pigCode, String idOrigin) {
        return pigRepository.searchPig(isSold,"%"+pigCode+"%",idOrigin);
    }

    @Override
    public Pig findById(int id) {
        return pigRepository.findById(id).get();
    }

//    @Transactional
    @Override
    public boolean deletePigById(int id) {
        try {
            pigRepository.deletePig(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
