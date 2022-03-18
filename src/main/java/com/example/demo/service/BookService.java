package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    void addBook(Book book);
    List<Book> getListBook();
    Map<String, Book> getMapBook();
//    List<Book> getListBookInValue(String value);

    List<Book> getListBookInValueDB(String value);
}
