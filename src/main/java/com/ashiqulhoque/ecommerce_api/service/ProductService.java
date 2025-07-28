package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.dto.ProductSaleSummaryDTO;
import com.ashiqulhoque.ecommerce_api.repository.ProductwiseOderHistoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductwiseOderHistoryRepository productwiseOderHistoryRepository;

    public ProductService(ProductwiseOderHistoryRepository productwiseOderHistoryRepository) {
        this.productwiseOderHistoryRepository = productwiseOderHistoryRepository;
    }

    public List<ProductSaleSummaryDTO> getTopProductBySales() {
        List<Object[]> topProducts = productwiseOderHistoryRepository.findTopProductsBySales(PageRequest.of(0,2));

        List<ProductSaleSummaryDTO> productSaleSummaryDTOS = topProducts.stream()
                .map(p -> new ProductSaleSummaryDTO(p[1].toString(), (BigDecimal) p[2], null))
                .toList();

        return productSaleSummaryDTOS;
    }

    public List<ProductSaleSummaryDTO> getTopProductByQuantity() {
        List<Object[]> topProducts = productwiseOderHistoryRepository.findTopProductsByQuantity(PageRequest.of(0,2));

        List<ProductSaleSummaryDTO> productSaleSummaryDTOS = topProducts.stream()
                .map(p -> new ProductSaleSummaryDTO(p[1].toString(), (BigDecimal) null, (Number) p[2]))
                .toList();

        return productSaleSummaryDTOS;
    }
}
