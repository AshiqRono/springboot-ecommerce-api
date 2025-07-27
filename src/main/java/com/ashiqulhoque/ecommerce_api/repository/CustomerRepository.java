package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
