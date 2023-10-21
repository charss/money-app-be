package com.example.moneyapp.category;

import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.Transaction;
import com.example.moneyapp.entity.User;
import com.example.moneyapp.transaction.TransactionController;
import com.example.moneyapp.transaction.TransactionDto;
import com.example.moneyapp.transaction.TransactionMapper;
import com.example.moneyapp.transaction.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

//    public List<CategoryWithTotalDto> getAllCategoryWithTotal() {
//        try {
//            List<Category> categories = this.categoryRepo.findAll();
//
//            return categories
//                    .stream()
//                    .map(category -> {
//                        double total = 0;
//                        for (int i = 0; i < category.getTransactions().size(); i++) {
//                            System.out.print(i + " - ");
//                            total += category.getTransactions().get(i).getAmount();
//                        }
//                        return new CategoryWithTotalDto(
//                                category.getId(),
//                                category.getName(),
//                                category.getUserId(),
//                                total
//                        );
//                    })
//                    .collect(toList());
//        } catch (EntityNotFoundException e) {
//            return null;
//        }
//    }

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
