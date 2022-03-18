package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class Controller {
    private final BookService bookService;

    @GetMapping("/book")
    public List<Book> returnListBook() {
        return bookService.getListBook();
    }

    @GetMapping("/count")
    public Map<String, Book> returnCountBook() {
        return bookService.getMapBook();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/search")
    public List<Book> searchBookValue(@RequestParam String value) {
       return bookService.getListBookInValueDB(value);
    }
}
