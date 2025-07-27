package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import com.ashiqulhoque.ecommerce_api.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    CustomerService customerService;

    @Test
    public void testGetCustomerWishListByCustomerId() throws Exception {
        Wishlist mockWishList = new Wishlist();
        mockWishList.setId(1l);
        mockWishList.setCustId(1l);
        mockWishList.setProductIds(Set.of(2l, 3l));

        when(customerService.getWishListByCustomerId(1l)).thenReturn(mockWishList);

        mockMvc.perform(get("/api/customer/wishlist/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
