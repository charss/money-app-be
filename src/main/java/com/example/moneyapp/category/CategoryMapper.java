package com.example.moneyapp.category;

import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.Transaction;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        Set<Transaction> transactions = new HashSet<>(category
                .getTransactions());

        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getUserId(),
                transactions,
                OffsetDateTime.ofInstant(category.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(category.getUpdatedAt().toInstant(), ZoneId.systemDefault())
        );
    }

    public CategoryWithTotalDto toWithTotalDto(Category category, Double total) {
        return null;
    }

}
