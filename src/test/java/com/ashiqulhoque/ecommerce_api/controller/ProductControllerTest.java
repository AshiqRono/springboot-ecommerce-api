package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.service.ProductService;
import com.ashiqulhoque.ecommerce_api.service.SalesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    ProductService productService;

    @Test
    public void testGetTopSelling5() throws Exception {
        mockMvc.perform(get("/api/product/topSelling5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMostSelling5() throws Exception {
        mockMvc.perform(get("/api/product/mostSelling5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
