package com.example.BookProject.configuration;

import com.example.BookProject.model.BookModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookModel BookModelObj() {
        return new BookModel();
    }
}
