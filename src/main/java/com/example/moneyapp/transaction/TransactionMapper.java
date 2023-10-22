package com.example.moneyapp.transaction;

import com.example.moneyapp.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class TransactionMapper {
    public TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getAccount().getName(),
//                transaction.getCategory().getName(),
                OffsetDateTime.ofInstant(transaction.getTransactionDate().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(transaction.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(transaction.getUpdatedAt().toInstant(), ZoneId.systemDefault())
        );
    }
}
