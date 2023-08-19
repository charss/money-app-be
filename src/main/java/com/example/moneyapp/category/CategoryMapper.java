package com.example.moneyapp.category;

import com.example.moneyapp.entity.Category;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getUserId(),
                OffsetDateTime.ofInstant(category.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(category.getUpdatedAt().toInstant(), ZoneId.systemDefault())
        );
    }
}
