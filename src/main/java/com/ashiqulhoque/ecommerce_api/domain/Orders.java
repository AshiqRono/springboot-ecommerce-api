package com.ashiqulhoque.ecommerce_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends AbstractRetirableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "product_ids")
    private Set<Long> productIds;

    @Column(name = "total_amount", precision = 10, scale = 4)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 50, nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "order_placed_at")
    private LocalDateTime orderPlacedAt;

    @Column(name = "order_delivered_at")
    private LocalDateTime orderDeliveredAt;

    @Column(name = "order_cancelled_at")
    private LocalDateTime orderCancelledAt;
}
