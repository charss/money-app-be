package com.example.moneyapp.category;

import com.example.moneyapp.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;
import java.util.Set;

public record CategoryDto(
        Integer id,
        String name,
        Integer userId,
        Set<Transaction> transaction,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime updatedAt
) { }