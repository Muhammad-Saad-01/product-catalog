package net.muhammadsaad.rest.repository;

import net.muhammadsaad.rest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
