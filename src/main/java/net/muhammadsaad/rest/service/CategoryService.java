package net.muhammadsaad.rest.service;

import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long categoryId);

    Category updateCategoryById(Long categoryId);

    void deleteCategoryById(Long categoryId);

    Category addCategory(Category category);
}
