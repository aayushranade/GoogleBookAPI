package com.example.BookProject.service;

import com.example.BookProject.model.Book;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

//    private final RestTemplate restTemplate;
//
//    public BookService(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder.build();
//    }
//
//    public Book getBookByName(String name) {
//        String url = "https://www.googleapis.com/books/v1/volumes?q={name}";
//        ResponseEntity<Book> response = this.restTemplate.getForEntity(url, Book.class);
//        if(response.getStatusCode() == HttpStatus.OK) {
//            return response.getBody();
//        } else {
//            return null;
//        }
//    }

}
