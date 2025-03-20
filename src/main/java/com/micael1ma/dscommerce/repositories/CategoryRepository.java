package com.micael1ma.dscommerce.repositories;

import com.micael1ma.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
