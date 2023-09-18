package com.example.service;

import com.example.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private DictionaryRepository dictionaryRepository;
    public String translate(String englishWord){
        Map<String,String> stringMap = dictionaryRepository.findAll();
        for(String key:stringMap.keySet()){
            if(Objects.equals(key, englishWord.trim().toLowerCase())){
                return stringMap.get(key);
            }
        }
        return "Không tìm thấy kết quả tương ứng!";
    }
}
