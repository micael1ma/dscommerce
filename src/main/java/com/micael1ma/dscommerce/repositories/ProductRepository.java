package com.micael1ma.dscommerce.repositories;


import com.micael1ma.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
