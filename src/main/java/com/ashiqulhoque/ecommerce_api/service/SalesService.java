package com.ashiqulhoque.ecommerce_api.service;

import com.ashiqulhoque.ecommerce_api.dto.SaleSummaryDTO;
import com.ashiqulhoque.ecommerce_api.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class SalesService {

    private final OrderRepository orderRepository;

    public SalesService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public SaleSummaryDTO findTotalSaleOfTheDay(LocalDate startDate) {
        LocalDate start = startDate != null ? startDate : LocalDate.now();

        List<Object[]> results = orderRepository.findTotalSaleOfTheDay(start);

        Object[ ] result = results.get(0);

        return new SaleSummaryDTO(result[0].toString(), (BigDecimal) result[1]);
    }

    public SaleSummaryDTO findMaxSalePerDay(LocalDate startDate, LocalDate endDate) {
        List<Object[]> results = orderRepository.findMaxSalesPerDay(startDate, endDate);

        if (results.isEmpty()) {
            // no idea what to show or how to deal with this scenario
            // a given time range where there is zero order placed which has been shipped or delivered
            // so there is no sale information during that time
            // what to show??
            log.info("No sale data between {} and {}", startDate, endDate);
            return new SaleSummaryDTO(LocalDate.now().toString(), BigDecimal.ZERO);
        }

        Object[] maxSale = results.get(0);
        return new SaleSummaryDTO(maxSale[0].toString(), (BigDecimal) maxSale[1]);

    }


}
