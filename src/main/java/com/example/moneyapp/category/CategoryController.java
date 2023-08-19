package com.example.moneyapp.category;

import com.example.moneyapp.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<Category> listAll() {
        return this.categoryRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Category category) {
        return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.CREATED);
    }
}
