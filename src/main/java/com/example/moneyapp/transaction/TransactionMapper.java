package com.example.moneyapp.transaction;

import com.example.moneyapp.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionDto toDto(Transaction transaction) {
        Double amount = transaction.getAmount();
        String type = transaction.getType();
        Integer categoryId = transaction.getCategoryId();
        Integer accountId = transaction.getAccountId();

        return new TransactionDto(amount, type, categoryId, accountId);
    }
}
