package com.example.library.service;

import com.example.library.model.BookCode;

public interface IBookCodeService {
    int randomCode();
    int findByBookCode(int bookCode);
    boolean save(BookCode bookCode);
}
