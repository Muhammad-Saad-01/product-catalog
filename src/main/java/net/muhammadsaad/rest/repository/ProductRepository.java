package net.muhammadsaad.rest.repository;

import net.muhammadsaad.rest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIdAndPriceBetween(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByCategoryId(Long categoryId);
}
