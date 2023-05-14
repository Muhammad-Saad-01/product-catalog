package net.muhammadsaad.rest.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.muhammadsaad.rest.entity.Category;
import net.muhammadsaad.rest.exception.ResourceNotFoundException;
import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.mapper.CategoryMapper;
import net.muhammadsaad.rest.mapper.ProductMapper;
import net.muhammadsaad.rest.model.CategoryModel;
import net.muhammadsaad.rest.model.ProductModel;
import net.muhammadsaad.rest.repository.CategoryRepository;
import net.muhammadsaad.rest.repository.ProductRepository;
import net.muhammadsaad.rest.service.CategoryService;
import net.muhammadsaad.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ProductModel getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.map(ProductMapper::toModel).orElse(null);
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        Product product = ProductMapper.toEntity(productModel);

        // Check if the category exists by name
        CategoryModel categoryModel = productModel.getCategory();
        CategoryModel existingCategoryModel = categoryService.getCategoryByName(categoryModel.getName());
        // If the category doesn't exist, create a new one
        if (existingCategoryModel == null) {
            Category category = CategoryMapper.toEntity(categoryModel);
            // Set any other properties for the category if needed
            // Save the new category
            categoryService.createCategory(categoryModel);

            // Set the category for the product
            product.setCategory(category);
        }

        // Save the product
        Product savedProduct = productRepository.save(product);

        log.info("Product With Id {} Was Created", productModel.getId());
        // Map the saved product back to a model object
        return ProductMapper.toModel(savedProduct);

    }

    @Override
    public void activateProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        optionalProduct.ifPresent(product -> {
            product.setIsActive(true);
            productRepository.save(product);
        });
    }

    @Override
    public void deactivateProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        optionalProduct.ifPresent(product -> {
            product.setIsActive(false);
            productRepository.save(product);
        });
    }

    @Override
    public ProductModel updateProduct(Long productId, ProductModel productModel) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productModel.getName());
            existingProduct.setDescription(productModel.getDescription());
            existingProduct.setPrice(productModel.getPrice());

            existingProduct.setCategory(CategoryMapper.toEntity(productModel.getCategory()));

            Product updatedProduct = productRepository.save(existingProduct);
            return ProductMapper.toModel(updatedProduct);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + productId);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            productRepository.deleteById(productId);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + productId);
        }
    }

    @Override
    public List<ProductModel> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        return products.stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> getProductsByCategoryAndPriceRange(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> products = productRepository.findByCategoryIdAndPriceBetween(categoryId, minPrice, maxPrice);
        return products.stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }
}
