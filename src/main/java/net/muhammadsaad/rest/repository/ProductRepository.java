package net.muhammadsaad.rest.repository;

import net.muhammadsaad.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
