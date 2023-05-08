package net.muhammadsaad.rest.service;

import net.muhammadsaad.rest.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(Long productId);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Product addProduct(Product product);
}
