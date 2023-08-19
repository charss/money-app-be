package com.example.moneyapp.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCategoryId(Integer categoryId);
    List<Transaction> findByAccountId(Integer accountId);
    List<Transaction> findByType(String type);
}
