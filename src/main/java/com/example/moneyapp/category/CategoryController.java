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
    private CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepo, CategoryMapper mapper, CategoryService categoryService) {
        this.categoryRepo = categoryRepo;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public List<CategoryDto> listAll() {
//        return this.categoryRepo.findAll()
//                .stream()
//                .map(mapper::toDto)
//                .collect(toList());
//    }
//    @GetMapping("/total")
//    public List<CategoryWithTotalDto> listAllWithTotal() {
//        return this.categoryService.getAllCategoryWithTotal();
//    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Category category) {
        return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public Category updateCategory(@PathVariable(value = "id") Integer id, @RequestBody Category category) {
        return this.categoryService.updateCategory(id, category);
    }
}
