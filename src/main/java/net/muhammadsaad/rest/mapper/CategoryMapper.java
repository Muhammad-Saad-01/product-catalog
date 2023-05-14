package net.muhammadsaad.rest.mapper;

import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.model.CategoryModel;

public class CategoryMapper {
    public static CategoryModel toModel(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setName(category.getName());
        categoryModel.setDescription(category.getDescription());
        categoryModel.setIsActive(category.getIsActive());
        return categoryModel;
    }
    public static Category toEntity(CategoryModel categoryModel) {
        Category category = new Category(categoryModel.getName(), categoryModel.getDescription());
        category.setId(categoryModel.getId());
        category.setName(categoryModel.getName());
        category.setDescription(categoryModel.getDescription());
        category.setIsActive(categoryModel.getIsActive());
        return category;
    }

}
