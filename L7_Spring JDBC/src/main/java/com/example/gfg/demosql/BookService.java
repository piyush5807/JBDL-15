package com.example.gfg.demosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service   // Business logic
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(BookRequest bookRequest) throws SQLException {

        // DB insert into book VALUES()

        bookRepository.createBook(bookRequest);
    }

    public List<Book> getBooks() throws SQLException {

        // DB select * from book;

        return bookRepository.getBooks();
    }

    public Book getBookById(int id) throws SQLException {

        // DB select * from book where id = id

        return bookRepository.getBookById(id);
    }
}
