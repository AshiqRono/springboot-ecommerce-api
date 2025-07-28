package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.domain.OrderStatus;
import com.ashiqulhoque.ecommerce_api.domain.Orders;
import com.ashiqulhoque.ecommerce_api.repository.OrderRepository;
import com.ashiqulhoque.ecommerce_api.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
@Transactional
public class SalesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SalesService salesService;

    @BeforeEach
    public void setup() {
        Orders order1 = new Orders();
        order1.setId(1l);
        order1.setOrderStatus(OrderStatus.DELIVERED);
        order1.setOrderPlacedAt(LocalDate.parse("2025-06-20"));
        order1.setTotalAmount(BigDecimal.valueOf(800l));
        orderRepository.save(order1);
        Orders order2 = new Orders();
        order2.setId(2l);
        order2.setOrderStatus(OrderStatus.DELIVERED);
        order2.setOrderPlacedAt(LocalDate.parse("2025-06-26"));
        order2.setTotalAmount(BigDecimal.valueOf(600l));
        orderRepository.save(order2);

    }

    @Test
    void testGetTotalSaleOfTheDay() throws Exception {
        mockMvc.perform(get("/api/sales/totalSaleOfTheDay?start=2025-06-26"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.saleDate").value("2025-06-26"))
                .andExpect(jsonPath("$.totalSales").value(600.0));
    }

    @Test
    void testGetMaxSaleDay() throws Exception {
        mockMvc.perform(get("/api/sales/maxSaleDay?start=2025-06-10&end=2025-06-30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.saleDate").value("2025-06-20"))
                .andExpect(jsonPath("$.totalSales").value(800.0));
    }
}
