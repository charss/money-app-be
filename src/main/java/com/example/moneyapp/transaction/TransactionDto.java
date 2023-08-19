package com.example.moneyapp.transaction;

public record TransactionDto(
        Double amount,
        String type,
        Integer categoryId,
        Integer accountId
) { }
