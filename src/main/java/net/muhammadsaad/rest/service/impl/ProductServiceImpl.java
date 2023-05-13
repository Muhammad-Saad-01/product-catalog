package net.muhammadsaad.rest.service.impl;

import net.muhammadsaad.rest.exception.ResourceNotFoundException;
import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.mapper.ProductMapper;
import net.muhammadsaad.rest.model.ProductModel;
import net.muhammadsaad.rest.repository.ProductRepository;
import net.muhammadsaad.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductModel updateProduct(Long id, ProductModel product) {
        Product product = ProductMapper.toEntity(product);
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
    }
}
