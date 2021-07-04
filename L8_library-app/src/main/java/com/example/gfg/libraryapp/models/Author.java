package com.example.gfg.libraryapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
    private String country;


    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> books;

}
