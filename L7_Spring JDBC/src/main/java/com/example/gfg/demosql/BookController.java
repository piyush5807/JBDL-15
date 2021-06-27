package com.example.gfg.demosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public BookResponse getBooks() throws SQLException {
        List<Book> books = bookService.getBooks();
        return BookResponse.toBookResponse(books);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody BookRequest bookRequest) throws SQLException {
        bookService.createBook(bookRequest);
    }

    @GetMapping("/book/{id}")
    public BookResponse getBookById(@PathVariable("id") int id) throws SQLException {
        Book book = bookService.getBookById(id);
        return BookResponse.toBookResponse(book == null ? new ArrayList<>() : Arrays.asList(book));
    }
}
