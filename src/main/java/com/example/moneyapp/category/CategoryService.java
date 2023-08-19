package com.example.moneyapp.category;

import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category updateCategory(Integer id, Category updatedCategory) {
        try {
            Category category = this.categoryRepo.getReferenceById(id);

            if (!Objects.equals(category.getName(), updatedCategory.getName())) {
                category.setName(updatedCategory.getName());
                return this.categoryRepo.save(category);
            }

            return category;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
