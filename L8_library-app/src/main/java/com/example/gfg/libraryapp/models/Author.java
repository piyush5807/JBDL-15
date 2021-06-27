package com.example.gfg.libraryapp.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    private int id;
    private String name;

    private String email;
    private int age;
    private String country;


    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
