package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface BookRepositoryInt extends JpaRepository<Book, UUID> {

    ArrayList<Book> findAllByNameStartingWith(String s);

}
