package com.ashiqulhoque.ecommerce_api.controller;

import com.ashiqulhoque.ecommerce_api.dto.SaleSummaryDTO;
import com.ashiqulhoque.ecommerce_api.service.SalesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private SalesService salesService;

    public SalesController (SalesService salesService) {
        this.salesService = salesService;
    }

    /**
     * returns total sales amount of the current day
     * @return
     */
    @GetMapping(value = "/totalSaleOfTheDay")
    public ResponseEntity<SaleSummaryDTO> getTotalSaleOfTheDay() {
        // placeholder api
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    /**
     * returns max sale day of a certain time range
     * @param start
     * @param end
     * @return
     */
    @GetMapping(value = "/maxSaleDay")
    public ResponseEntity<SaleSummaryDTO> getMaxSaleDay(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                        @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        // placeholder api
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
