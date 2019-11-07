package com.fwindpeak.bootfirst.service;

import com.fwindpeak.bootfirst.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getList() {

        String sql = "select user_id,user_phone,user_name,his_money from bn_user";
        return (List) jdbcTemplate.query(sql, new RowMapper() {

            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setContent(rs.getString("content"));

                return book;
            }

        });
    }
}
