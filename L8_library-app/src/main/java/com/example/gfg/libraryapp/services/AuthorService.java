package com.example.gfg.libraryapp.services;

import com.example.gfg.libraryapp.models.Author;
import com.example.gfg.libraryapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author getAuthorByEmail(String email){
        return authorRepository.findByEmail(email);
    }
}
