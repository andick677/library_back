package org.example.library.Service;

import org.example.library.Dao.BookDao;
import org.example.library.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBook(){
        return bookDao.getAllBook();
    }
    public Book getBookId(String title){
        return bookDao.getBookId(title);
    }
}
