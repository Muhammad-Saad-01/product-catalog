package net.muhammadsaad.rest.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.mapper.CategoryMapper;
import net.muhammadsaad.rest.model.CategoryModel;
import net.muhammadsaad.rest.repository.CategoryRepository;
import net.muhammadsaad.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

//    which one is right CategoryMapper with static Methods or object of categoryMapper


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toModel)
                .collect(Collectors.toList());

    }

    @Override
    public CategoryModel getCategoryById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        return categoryOptional.map(CategoryMapper::toModel).orElse(null);
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        return categoryOptional.map(CategoryMapper::toModel).orElse(null);
    }

    @Override
    public CategoryModel updateCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public CategoryModel updateCategoryById(Long categoryId, CategoryModel categoryModel) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryModel.getName());
            category.setDescription(categoryModel.getDescription());
            category.setIsActive(categoryModel.getIsActive());
            categoryRepository.save(category);
            return CategoryMapper.toModel(category);
        }
        return null;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        Category category = CategoryMapper.toEntity(categoryModel);
        category.setIsActive(true);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toModel(savedCategory);
    }

    @Override
    public CategoryModel updateCategory(Long categoryId, CategoryModel categoryModel) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryModel.getName());
            category.setDescription(categoryModel.getDescription());
            category.setIsActive(categoryModel.getIsActive());
            Category savedCategory = categoryRepository.save(category);
            return CategoryMapper.toModel(savedCategory);
        }
        return null;
    }

    @Override
    public CategoryModel activateCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setIsActive(true);
            Category savedCategory = categoryRepository.save(category);
            return CategoryMapper.toModel(savedCategory);
        }
        return null;
    }

    @Override
    public CategoryModel deactivateCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setIsActive(false);
            Category savedCategory = categoryRepository.save(category);
            return CategoryMapper.toModel(savedCategory);
        }
        return null;
    }
}
