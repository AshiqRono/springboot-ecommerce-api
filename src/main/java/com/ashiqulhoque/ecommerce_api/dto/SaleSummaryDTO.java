package com.ashiqulhoque.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SaleSummaryDTO {
    private String saleDate;
    private BigDecimal totalSales;
}
