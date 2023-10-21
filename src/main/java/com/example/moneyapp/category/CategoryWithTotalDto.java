package com.example.moneyapp.category;

public record CategoryWithTotalDto(
        Integer id,
        String name,
        Integer userId,
        Double total
) { }