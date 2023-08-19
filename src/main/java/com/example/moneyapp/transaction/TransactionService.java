package com.example.moneyapp.transaction;

import com.example.moneyapp.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepo;
    private CategoryRepository categoryRepo;

    public TransactionService(TransactionRepository transactionRepo, CategoryRepository categoryRepo) {
        this.transactionRepo = transactionRepo;
        this.categoryRepo = categoryRepo;
    }

//    public List<TransactionDto> getAllTransactionsByCategory(Integer id) {
//        return
//    }
}
