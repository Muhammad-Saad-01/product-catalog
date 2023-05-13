package net.muhammadsaad.rest.controller;

import net.muhammadsaad.rest.exception.ResourceNotFoundException;
import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@Validated @RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product update) {
        Optional<Product> existingProduct = productService.getProductById(id);

        if (existingProduct.isEmpty()) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }


        Product product = existingProduct.get();
        if (update.getName() != null) {
            product.setName(update.getName());
        }
        if (update.getDescription() != null) {
            product.setDescription(update.getDescription());
        }
        if (update.getPrice() != null) {
            product.setPrice(update.getPrice());
        }
        if (update.getIsAvailable() != null) {
            product.setIsAvailable(update.getIsAvailable());
        }
        if (update.getImageUrl() != null) {
            product.setImageUrl(update.getImageUrl());
        }

        Product updatedProduct = productService.updateProduct(id, product);

        /*
        * but what if there are a lot of properties
        * */
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
