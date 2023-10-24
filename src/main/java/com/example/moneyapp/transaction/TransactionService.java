package com.example.moneyapp.transaction;

import com.example.moneyapp.account.AccountRepository;
import com.example.moneyapp.category.CategoryRepository;
import com.example.moneyapp.entity.Account;
import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.Transaction;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
public class TransactionService {
    private TransactionRepository transactionRepo;
    private AccountRepository accountRepo;
    private CategoryRepository categoryRepo;
    private TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepo,
                              AccountRepository accountRepo,
                              CategoryRepository categoryRepo,
                              TransactionMapper transactionMapper
    ) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
        this.categoryRepo = categoryRepo;
        this.transactionMapper = transactionMapper;
    }

    public void add(CreateTransactionDto createTransactionDto) {
        Account account = this.accountRepo.getReferenceById(createTransactionDto.accountId());
        Category category = this.categoryRepo.getReferenceById(createTransactionDto.categoryId());

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setCategory(category);
        transaction.setAmount(createTransactionDto.amount());

        this.transactionRepo.save(transaction);
    }

    public TransactionDto updateTransactionDate(Integer id, Transaction updatedTransaction) {
        try {
            Transaction transaction = this.transactionRepo.getReferenceById(id);

            if (!Objects.equals(transaction.getTransactionDate(), updatedTransaction.getTransactionDate())) {
                transaction.setTransactionDate(updatedTransaction.getTransactionDate());

                OffsetDateTime updatedDate = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
                Date date = Date.from(updatedDate.toInstant());
                transaction.setUpdatedAt(date);

                this.transactionRepo.save(transaction);
            }

            return transactionMapper.toDto(transaction);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
