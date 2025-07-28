package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.service.SalesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
public class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SalesService salesService;

    @Test
    public void testGetTotalSaleOfTheDay() throws Exception {
        mockMvc.perform(get("/api/sales/totalSaleOfTheDay").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMaxSaleDay() throws Exception {
        mockMvc.perform(get("/api/sales/maxSaleDay")
                        .param("start", "2025-01-01")
                        .param("end", "2025-01-31"))
                .andExpect(status().isOk());
    }
}
