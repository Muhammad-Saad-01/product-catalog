package net.muhammadsaad.rest.service;

import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.model.ProductModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> getAllProducts();

    ProductModel getProductById(Long productId);

    List<ProductModel> getProductsByCategory(Long categoryId);
    List<ProductModel> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<ProductModel> getProductsByCategoryAndPriceRange(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice);

    ProductModel createProduct(ProductModel product);
    ProductModel updateProduct(Long productId, ProductModel productModel);
    void deleteProduct(Long id);
    void activateProduct(Long productId);
    void deactivateProduct(Long productId);
}
