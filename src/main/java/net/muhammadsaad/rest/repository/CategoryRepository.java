package net.muhammadsaad.rest.repository;

import net.muhammadsaad.rest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
