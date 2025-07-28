package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.OrderStatus;
import com.ashiqulhoque.ecommerce_api.domain.Orders;
import com.ashiqulhoque.ecommerce_api.domain.Product;
import com.ashiqulhoque.ecommerce_api.domain.ProductwiseOrderHistory;
import com.ashiqulhoque.ecommerce_api.repository.OrderRepository;
import com.ashiqulhoque.ecommerce_api.repository.ProductRepository;
import com.ashiqulhoque.ecommerce_api.repository.ProductwiseOderHistoryRepository;
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
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductwiseOderHistoryRepository  productwiseOderHistoryRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Product product1 = new Product();
        product1.setId(1l);
        product1.setName("Product 1");
        product1.setPrice(BigDecimal.valueOf(100l));
        productRepository.save(product1);
        Product product2 = new Product();
        product2.setId(2l);
        product2.setName("Product 2");
        product2.setPrice(BigDecimal.valueOf(200l));
        productRepository.save(product2);

        Orders order1 = new Orders();
        order1.setId(1l);
        order1.setProductIds(Collections.singleton(1l));
        order1.setOrderStatus(OrderStatus.DELIVERED);
        orderRepository.save(order1);
        Orders order2 = new Orders();
        order2.setId(2l);
        order2.setProductIds(Collections.singleton(2l));
        order2.setOrderStatus(OrderStatus.DELIVERED);
        orderRepository.save(order2);

        ProductwiseOrderHistory productwiseOrderHistory1 = new ProductwiseOrderHistory();
        productwiseOrderHistory1.setId(1l);
        productwiseOrderHistory1.setProductName(product1.getName());
        productwiseOrderHistory1.setOrderId(order1.getId());
        productwiseOrderHistory1.setProductId(product1.getId());
        productwiseOrderHistory1.setQuantity(3);
        productwiseOrderHistory1.setTotalPrice(BigDecimal.valueOf(300l));
        productwiseOrderHistory1.setOrderStatus(OrderStatus.DELIVERED);
        productwiseOderHistoryRepository.save(productwiseOrderHistory1);
        ProductwiseOrderHistory productwiseOrderHistory2 = new ProductwiseOrderHistory();
        productwiseOrderHistory2.setId(2l);
        productwiseOrderHistory2.setProductName(product2.getName());
        productwiseOrderHistory2.setOrderId(order2.getId());
        productwiseOrderHistory2.setProductId(product2.getId());
        productwiseOrderHistory2.setQuantity(2);
        productwiseOrderHistory2.setTotalPrice(BigDecimal.valueOf(400l));
        productwiseOrderHistory2.setOrderStatus(OrderStatus.DELIVERED);
        productwiseOderHistoryRepository.save(productwiseOrderHistory2);

    }

    @Test
    void testGetTopSelling() throws Exception {
        mockMvc.perform(get("/api/product/topSelling"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].productName").value("Product 2"))
                .andExpect(jsonPath("$.[0].totalSales").value("400.0"))
                .andExpect(jsonPath("$.[1].productName").value("Product 1"))
                .andExpect(jsonPath("$.[1].totalSales").value("300.0"));
    }

    @Test
    void testGetMostSelling() throws Exception {
        mockMvc.perform(get("/api/product/mostSelling"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].productName").value("Product 1"))
                .andExpect(jsonPath("$.[0].quantity").value(3))
                .andExpect(jsonPath("$.[1].productName").value("Product 2"))
                .andExpect(jsonPath("$.[1].quantity").value(2));
    }
}
