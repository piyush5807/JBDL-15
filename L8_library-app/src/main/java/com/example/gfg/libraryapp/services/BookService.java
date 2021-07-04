package com.example.gfg.libraryapp.services;

import com.example.gfg.libraryapp.models.Author;
import com.example.gfg.libraryapp.models.Book;
import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.repository.BookRepository;
import com.example.gfg.libraryapp.requests.BookCreateRequest;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Book getBook(int id){
        return bookRepository.findById(id).orElse(Book.builder().build());
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void createBookWithAuthorDetails(BookCreateRequest bookCreateRequest){

        String email = bookCreateRequest.getAuthor().getEmail();
        Author author = authorService.getAuthorByEmail(email);

        Book book = Book.builder()
                .cost(bookCreateRequest.getCost())
                .name(bookCreateRequest.getName())
                .bookCategory(bookCreateRequest.getBookCategory())
                .build();

        if (author == null) {
          author = Author.builder()
                  .name(bookCreateRequest.getAuthor().getName())
                  .email(email)
                  .age(bookCreateRequest.getAuthor().getAge())
                  .country(bookCreateRequest.getAuthor().getCountry())
                  .books(
                      Arrays.asList(book)) // 2 books
                  .build();

          author = authorService.createAuthor(author);
        }

        book.setAuthor(author);
        bookRepository.save(book);

    }

    public void createOrUpdateBook(Book book){
        bookRepository.save(book);
    }
}
