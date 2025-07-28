package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.dto.WishlistDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final WishlistService wishlistService;

    public CustomerService(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    public WishlistDTO getWishListByCustomerId(Long customerId) {
        return wishlistService.getByCustomerId(customerId);
    }
}
