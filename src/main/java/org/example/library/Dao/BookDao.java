package org.example.library.Dao;


import org.example.library.Model.Book;
import org.example.library.Rowmapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Book> getAllBook(){
        String sql = "SELECT book_id, title, author, image_url, price, published_date, created_date, last_modified_date " +
                "FROM library.book";

        Map<String,Object> map = new HashMap<>();

        List<Book> bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        return bookList;

    }
    public Book getBookId(String title){
        String sql = "SELECT book_id, title, author, image_url, price, published_date, created_date, last_modified_date " +
                "FROM library.book WHERE title LIKE CONCAT('%', :title, '%');";

        Map<String,Object> map = new HashMap<>();
        map.put("title",title);

        List<Book> bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        if (bookList.size() > 0) {
            return bookList.get(0);
        } else {
            return null;
        }
    }
}
