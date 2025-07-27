package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import com.ashiqulhoque.ecommerce_api.repository.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCustomerWishListByCustomerId() {
        Wishlist mockWishList = new Wishlist();
        mockWishList.setId(1l);
        mockWishList.setCustId(1l);
        mockWishList.setProductIds(Set.of(2l, 3l));

        when(wishlistRepository.findById(1L)).thenReturn(Optional.of(mockWishList));

        Wishlist result = customerService.getWishListByCustomerId(1L);

        assertNotNull(result);
    }
}
