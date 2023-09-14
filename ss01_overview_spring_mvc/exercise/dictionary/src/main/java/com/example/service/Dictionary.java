package com.example.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class Dictionary {
    private static Map<String, String> stringMap = new LinkedHashMap<String, String>();
    static {
        stringMap.put("hello","xin chào");
        stringMap.put("you","bạn");
        stringMap.put("he","anh ấy");
        stringMap.put("motorbike","xe máy");
        stringMap.put("book","quyển sách");
    }
    public String translate(String englishWord){
        for(String key:stringMap.keySet()){
            if(Objects.equals(key, englishWord.trim().toLowerCase())){
                return stringMap.get(key);
            }
        }
        return "Không tìm thấy kết quả tương ứng!";
    }
}
