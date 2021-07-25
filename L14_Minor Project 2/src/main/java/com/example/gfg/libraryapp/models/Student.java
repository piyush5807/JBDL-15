package com.example.gfg.libraryapp.models;

import com.example.gfg.libraryapp.security.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "my_email", unique = true, nullable = false)
    private String email;
    private int age;

    private String name;

    // first part of annotation corresponds to the class in which we are writing
    // second part corresponds to the object on top of which we are writing this annotation

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @OneToMany(mappedBy = "my_student")
    private List<Transaction> transactions;

    @CreationTimestamp
    private Date createdOn;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("student")
    private User user;
}
