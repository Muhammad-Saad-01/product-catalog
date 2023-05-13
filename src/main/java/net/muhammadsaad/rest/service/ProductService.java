package net.muhammadsaad.rest.service;

import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.model.ProductModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductModel getProductById(Long productId);
    List<Product> getAllProducts();
    List<ProductModel> getProductsByCategory(Long categoryId);
    List<ProductModel> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<ProductModel> getProductsByCategoryAndPriceRange(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice);
    ProductModel createProduct(ProductModel productModel);
    ProductModel updateProduct(Long productId, ProductModel productModel);
    void activateProduct(Long productId);
    void deactivateProduct(Long productId);
}
