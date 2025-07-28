package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.dto.WishlistDTO;
import com.ashiqulhoque.ecommerce_api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@Slf4j
@Tag(name = "Customer APIs", description = "Endpoints for managing customers")
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
    @Operation(summary = "Get customer wishlist by customer id", description = "Fetch the entire wishlist of a single customer")
    @GetMapping(value = "/wishlist/{cust_id}")
    public ResponseEntity<WishlistDTO> getCustomerWishList(@PathVariable("cust_id") Long cust_id) {
        log.info("Fetching wishlist of a single customer with customerId {}", cust_id);
        WishlistDTO wishlistDTO = customerService.getWishListByCustomerId(cust_id);
        return ResponseEntity.ok(wishlistDTO);
    }
}
