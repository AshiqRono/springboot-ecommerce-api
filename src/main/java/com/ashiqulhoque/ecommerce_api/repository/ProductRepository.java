package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findByIdIn(Set<Long> productIds);
}
