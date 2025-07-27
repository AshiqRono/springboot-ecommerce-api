package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import com.ashiqulhoque.ecommerce_api.service.CustomerService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * returns the wishlist of a customer
     * @param cust_id
     * @return
     */
    @GetMapping(value = "/wishlist/{cust_id}")
    public ResponseEntity<Wishlist> getCustomerWishList(@PathVariable("cust_id") Long cust_id) {
        // placeholder api
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
