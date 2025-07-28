package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.Customer;
import com.ashiqulhoque.ecommerce_api.domain.Product;
import com.ashiqulhoque.ecommerce_api.domain.Wishlist;
import com.ashiqulhoque.ecommerce_api.repository.CustomerRepository;
import com.ashiqulhoque.ecommerce_api.repository.ProductRepository;
import com.ashiqulhoque.ecommerce_api.repository.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
@Transactional
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @BeforeEach
    public void setup() {
        Product product = new Product();
        product.setId(1l);
        product.setName("Product 1");
        product.setPrice(BigDecimal.valueOf(100l));
        productRepository.save(product);

        Customer customer = new Customer();
        customer.setId(1l);
        customer.setFirstName("First Name");
        customer.setLastName("Last Name");
        customer.setEmail("Email");
        customerRepository.save(customer);

        Wishlist wishlist = new Wishlist();
        wishlist.setId(1l);
        wishlist.setCustId(1l);
        wishlist.setProductIds(Collections.singleton(1l));
        wishlistRepository.save(wishlist);

    }

    @Test
    void testGetCustomerWishList() throws Exception {
        mockMvc.perform(get("/api/customer/wishlist/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productInfoDTOList[0].productName").value("Product 1"))
                .andExpect(jsonPath("$.productInfoDTOList[0].productPrice").value("100.0"));
    }

}
