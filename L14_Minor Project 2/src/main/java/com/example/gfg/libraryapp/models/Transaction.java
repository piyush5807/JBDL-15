package com.example.gfg.libraryapp.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction { // transaction table

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // This is intended only for the external user querying part
    private String transactionId;

    @ManyToOne
    @JoinColumn
    private Book book;   // book_<primary_key>

    @ManyToOne
    @JoinColumn
    private Student my_student;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @CreationTimestamp
    private Date transactTime;

    private int fine;
    private String remarks;

}
