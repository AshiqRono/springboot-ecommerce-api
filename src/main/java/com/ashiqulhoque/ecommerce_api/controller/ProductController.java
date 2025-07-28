package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.dto.ProductSaleSummaryDTO;
import com.ashiqulhoque.ecommerce_api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
@Tag(name = "Product APIs", description = "Endpoints for managing products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * returns the top 2 selling products of all time
     * based on total sale of all time
     * @return
     */

    @Operation(summary = "Get top selling products by total amount of sales", description = "Fetch the topmost 2 products based on their total amount of sales")
    @GetMapping(value = "/topSelling")
    public ResponseEntity<List<ProductSaleSummaryDTO>> getTopSelling() {
        log.info("Fetching top products by total amount of sales");
        List<ProductSaleSummaryDTO> productSaleSummaryDTOS = productService.getTopProductBySales();
        return ResponseEntity.ok(productSaleSummaryDTOS);
    }

    /**
     * returns the top 2 selling products
     * based on the number of sale
     * @return
     */

    @Operation(summary = "Get top selling products by total number of sales", description = "Fetch the topmost 2 products based on their total number of sales")
    @GetMapping(value = "/mostSelling")
    public ResponseEntity<List<ProductSaleSummaryDTO>> getMostSelling() {
        log.info("Fetching top products by total number of sales");
        List<ProductSaleSummaryDTO> productSaleSummaryDTOS = productService.getTopProductByQuantity();
        return ResponseEntity.ok(productSaleSummaryDTOS);
    }
}
