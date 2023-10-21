package com.example.moneyapp.transaction;

import com.example.moneyapp.account.AccountRepository;
import com.example.moneyapp.category.CategoryRepository;
import com.example.moneyapp.entity.Account;
import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository transactionRepo;
    private AccountRepository accountRepo;
    private CategoryRepository categoryRepo;

    public TransactionService(TransactionRepository transactionRepo,
                              AccountRepository accountRepo,
                              CategoryRepository categoryRepo
    ) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
        this.categoryRepo = categoryRepo;
    }

    public void add(CreateTransactionDto createTransactionDto) {
        Account account = this.accountRepo.getReferenceById(createTransactionDto.accountId());
        Category category = this.categoryRepo.getReferenceById(createTransactionDto.categoryId());

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setCategory(category);
        transaction.setAmount(createTransactionDto.amount());
        transaction.setType(createTransactionDto.type());

        this.transactionRepo.save(transaction);
    }
}
