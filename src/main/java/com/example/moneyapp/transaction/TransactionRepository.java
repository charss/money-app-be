package com.example.moneyapp.transaction;

import com.example.moneyapp.entity.Account;
import com.example.moneyapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//    List<Transaction> findByCategoryId(Integer categoryId);
    List<Transaction> findByAccountId(Integer accountId);
//    List<Transaction> findByType(String type);
}
