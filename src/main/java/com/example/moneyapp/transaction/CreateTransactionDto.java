package com.example.moneyapp.transaction;

public record CreateTransactionDto(
        Integer accountId,
        Double amount,
        Integer categoryId,
        String type
) { }
