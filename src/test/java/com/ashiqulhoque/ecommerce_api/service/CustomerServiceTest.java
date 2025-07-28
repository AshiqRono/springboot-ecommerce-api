package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.dto.WishlistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWishListByCustomerId() {
        when(wishlistService.getByCustomerId(1l)).thenReturn(new WishlistDTO());

        WishlistDTO result = customerService.getWishListByCustomerId(1L);

        assertNotNull(result);
    }
}
