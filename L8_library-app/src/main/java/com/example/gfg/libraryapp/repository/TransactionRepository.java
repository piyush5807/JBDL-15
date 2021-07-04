package com.example.gfg.libraryapp.repository;

import com.example.gfg.libraryapp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    // This function should return the latest transaction made by this student for this book
    // and it should be a issue transaction

    @Query(value = "select * from Transaction t where t.book_book_id = ?1 and t.my_student_id = ?2 " +
            "order by t.id desc limit 1", nativeQuery = true)
    Transaction getTransaction(int bookId, int studentId);
}
