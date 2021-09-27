package com.example.BookProject.model;

import org.springframework.beans.factory.annotation.Autowired;

public class BookModel {
    @Autowired
    com.example.BookProject.repository.BookRepository contactRepository;
}
