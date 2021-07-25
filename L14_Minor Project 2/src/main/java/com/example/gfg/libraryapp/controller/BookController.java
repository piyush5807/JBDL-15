package com.example.gfg.libraryapp.controller;

import com.example.gfg.libraryapp.models.Book;
import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.requests.BookCreateRequest;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import com.example.gfg.libraryapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/book")
    public void createBook(@RequestBody BookCreateRequest bookCreateRequest){
        bookService.createBookWithAuthorDetails(bookCreateRequest);
    }

}
