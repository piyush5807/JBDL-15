package com.example.gfg.libraryapp.repository;

import com.example.gfg.libraryapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
