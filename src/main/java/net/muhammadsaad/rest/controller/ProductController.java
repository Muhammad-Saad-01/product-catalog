package net.muhammadsaad.rest.controller;

import net.muhammadsaad.rest.exception.ResourceNotFoundException;
import net.muhammadsaad.rest.entity.Product;
import net.muhammadsaad.rest.model.ProductModel;
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
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        ProductModel product = productService.getProductById(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ProductModel> addProduct(@Validated @RequestBody ProductModel product) {
        ProductModel savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    /*
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Validated @RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel update) {
        ProductModel existingProduct = productService.getProductById(id);

        if (existingProduct == null) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }


        if (update.getName() != null) {
            existingProduct.setName(update.getName());
        }
        if (update.getDescription() != null) {
            existingProduct.setDescription(update.getDescription());
        }
        if (update.getPrice() != null) {
            existingProduct.setPrice(update.getPrice());
        }
        if (update.getIsAvailable() != null) {
            existingProduct.setIsAvailable(update.getIsAvailable());
        }
        if (update.getImageUrl() != null) {
            existingProduct.setImageUrl(update.getImageUrl());
        }

        ProductModel updatedProduct = productService.updateProduct(id, existingProduct);

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
