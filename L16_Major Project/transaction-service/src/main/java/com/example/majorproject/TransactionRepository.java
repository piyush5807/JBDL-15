package com.example.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Transactional
    @Modifying
    @Query("update Transaction t set t.transactionStatus = :status where t.transactionId = :transactionId")
    void updateTransactionByStatus(TransactionStatus status, String transactionId);

    Transaction findByTransactionId(String id);
}
