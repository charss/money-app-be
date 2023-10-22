package com.example.moneyapp.transaction;
import java.time.OffsetDateTime;

public record CreateTransactionDto(
        Integer accountId,
        Double amount,
        Integer categoryId,
        String type,
        OffsetDateTime transactionDate
) { }
