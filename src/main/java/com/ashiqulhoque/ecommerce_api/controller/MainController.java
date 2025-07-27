package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.Customer;
import com.ashiqulhoque.ecommerce_api.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final CustomerRepository customerRepository;

    public MainController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
