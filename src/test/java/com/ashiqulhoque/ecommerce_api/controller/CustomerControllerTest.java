package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.dto.WishlistDTO;
import com.ashiqulhoque.ecommerce_api.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void testGetCustomerWishListByCustomerId() throws Exception {
        WishlistDTO mockWishList = new WishlistDTO();

        when(customerService.getWishListByCustomerId(1l)).thenReturn(mockWishList);

        mockMvc.perform(get("/api/customer/wishlist/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
