package com.example.BookProject.repository;

import com.example.BookProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertNewBookToDatabase(String kind, String id, String etag, String selflink) {
        String sql = "INSERT INTO aayushdb.books(kind,id,etag,selflink) VALUES(?,?,?,?)";
        Object params[] = new Object[] {kind,id,etag,selflink};
        jdbcTemplate.update(sql,params);
    }
}
