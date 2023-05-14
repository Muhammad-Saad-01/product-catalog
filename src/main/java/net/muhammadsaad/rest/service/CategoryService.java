package net.muhammadsaad.rest.service;

import net.muhammadsaad.rest.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    List<CategoryModel> getAllCategories();

    CategoryModel getCategoryById(Long categoryId);
    CategoryModel getCategoryByName(String categoryName);

    CategoryModel updateCategoryById(Long categoryId);

    CategoryModel updateCategoryById(Long categoryId, CategoryModel categoryModel);

    void deleteCategoryById(Long categoryId);

    CategoryModel createCategory(CategoryModel category);

    CategoryModel updateCategory(Long categoryId, CategoryModel categoryModel);

    CategoryModel activateCategory(Long categoryId);

    CategoryModel deactivateCategory(Long categoryId);
}
