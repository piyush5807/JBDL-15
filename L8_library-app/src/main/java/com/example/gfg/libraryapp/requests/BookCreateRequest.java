package com.example.gfg.libraryapp.requests;

import com.example.gfg.libraryapp.models.Author;
import com.example.gfg.libraryapp.models.BookCategory;
import com.example.gfg.libraryapp.models.Student;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {

    private String name;
    private int cost;
    private BookCategory bookCategory;
    private Author author;

}
