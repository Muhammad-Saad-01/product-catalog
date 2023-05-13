package net.muhammadsaad.rest.service.impl;

import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryId) {
        return Optional.empty();
    }

    @Override
    public Category updateCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {

    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }
}
