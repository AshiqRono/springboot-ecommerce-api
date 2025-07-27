package com.ashiqulhoque.ecommerce_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stock_added")
    private LocalDateTime stockAdded;

    @Column(name = "stock_removed")
    private LocalDateTime stockRemoved;
}
