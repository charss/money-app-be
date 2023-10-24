package com.example.moneyapp.transaction;

import com.example.moneyapp.entity.Account;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public record TransactionDto(
        Integer id,
        Double amount,
//        String categoryName,
//        Account account,
        String accountName,
        Integer categoryId,
        String type,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime transactionDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime updatedAt
) { }
