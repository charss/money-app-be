package com.example.moneyapp.category;

import com.example.moneyapp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepo;
    private CategoryMapper mapper;

    public CategoryController(CategoryRepository categoryRepo, CategoryMapper mapper) {
        this.categoryRepo = categoryRepo;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CategoryDto> listAll() {
        return this.categoryRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Category category) {
        return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.CREATED);
    }
}
