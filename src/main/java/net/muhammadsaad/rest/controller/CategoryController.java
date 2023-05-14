package net.muhammadsaad.rest.controller;

import net.muhammadsaad.rest.model.CategoryModel;
import net.muhammadsaad.rest.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryModel> addCategory(@RequestBody CategoryModel categoryModel) {
        CategoryModel createdCategory = categoryService.createCategory(categoryModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryModel> updateCategory(
            @PathVariable Long categoryId, @RequestBody CategoryModel categoryModel) {
        CategoryModel updatedCategory = categoryService.updateCategory(categoryId, categoryModel);
        return ResponseEntity.ok(updatedCategory);
    }

    @PatchMapping("/{categoryId}/activate")
    public ResponseEntity<CategoryModel> activateCategory(@PathVariable Long categoryId) {
        CategoryModel activatedCategory = categoryService.activateCategory(categoryId);
        return ResponseEntity.ok(activatedCategory);
    }

    @PatchMapping("/{categoryId}/deactivate")
    public ResponseEntity<CategoryModel> deactivateCategory(@PathVariable Long categoryId) {
        CategoryModel deactivatedCategory = categoryService.deactivateCategory(categoryId);
        return ResponseEntity.ok(deactivatedCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        List<CategoryModel> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable Long categoryId) {
        CategoryModel category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }
}
