package com.example.assetManage.controllers;

import com.example.assetManage.entities.Category;
import com.example.assetManage.exception.ResourceNotFoundException;
import com.example.assetManage.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateEmployee(@PathVariable(value = "id") Long categoryId,
                                                   @RequestBody Category categoryDetails) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        category.setC_name(categoryDetails.getC_name());
        final Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }
}
