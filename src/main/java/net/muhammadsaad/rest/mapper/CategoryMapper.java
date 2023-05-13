package net.muhammadsaad.rest.mapper;

import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.model.CategoryModel;

public class CategoryMapper {
    public static CategoryModel toCategoryModel(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(category.getName());
        categoryModel.setDescription(category.getDescription());
        // ... map other fields as needed
        return categoryModel;
    }

    public static Category toEntity(CategoryModel categoryModel) {
        Category category = new Category();

        category.setName(categoryModel.getName());
        category.setDescription(categoryModel.getDescription());
        // ... map other fields as needed
        return category;
    }
}
