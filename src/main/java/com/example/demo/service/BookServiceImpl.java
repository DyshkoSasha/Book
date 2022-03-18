package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepositoryInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepositoryInt bookRepositoryInt;

    @Override
    public void addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookRepositoryInt.save(book);
    }

    @Override
    public List<Book> getListBook() {
        return bookRepositoryInt.findAll();
    }

    @Override
    public Map<String, Book> getMapBook() {
        List<Book> listBooks = bookRepositoryInt.findAll();
        Map<String, Book> mapBooks = new HashMap<>();

        for (Book listBook : listBooks) {
            mapBooks.put(String.valueOf(listBook.getName().charAt(0)), listBook);
        }

        return mapBooks;
    }

//    @Override
//    public List<Book> getListBookInValue(String value) {
//        List<Book> all = bookRepositoryInt.findAll();
//
//        return all.stream().filter(book -> predic(value, book)).collect(Collectors.toList());
//    }
//
//    public boolean predic(String value, Book book) {
//        return book.getName().charAt(0) == value.charAt(0)  ;
//    }

    @Override
    public List<Book> getListBookInValueDB(String value) {
        return bookRepositoryInt.findAllByNameStartingWith(value);
    }
}
