package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
    private static Map<String, String> stringMap = new LinkedHashMap<String, String>();
    static {
        stringMap.put("hello","xin chào");
        stringMap.put("you","bạn");
        stringMap.put("he","anh ấy");
        stringMap.put("motorbike","xe máy");
        stringMap.put("book","quyển sách");
    }
    public Map<String, String> findAll(){
        return stringMap;
    }
}
