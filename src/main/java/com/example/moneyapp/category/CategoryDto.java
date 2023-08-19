package com.example.moneyapp.category;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public record CategoryDto(
        Integer id,
        String name,
        Integer userId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        OffsetDateTime updatedAt
) { }