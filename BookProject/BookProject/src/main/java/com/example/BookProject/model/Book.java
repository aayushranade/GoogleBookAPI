package com.example.BookProject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;

    public Book(String kind, String id, String etag, String selfLink) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
    }
}

