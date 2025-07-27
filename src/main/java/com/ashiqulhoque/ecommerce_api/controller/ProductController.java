package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.dto.ProductInfoDTO;
import com.ashiqulhoque.ecommerce_api.service.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * returns the top 5 selling products of all time
     * based on total sale of all time
     * @return
     */

    @GetMapping(value = "/topSelling5")
    public ResponseEntity<List<ProductInfoDTO>> getTopSelling5() {
        // placeholder api
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    /**
     * returns the top 5 selling products of the last month
     * based on the number of sale
     * @return
     */
    @GetMapping(value = "/mostSelling5")
    public ResponseEntity<List<ProductInfoDTO>> getMostSelling5() {
        // placeholder api
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
