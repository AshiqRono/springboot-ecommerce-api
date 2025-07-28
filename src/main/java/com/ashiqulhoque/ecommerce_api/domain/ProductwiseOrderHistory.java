package com.ashiqulhoque.ecommerce_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productwise_order_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductwiseOrderHistory extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(name = "unit_price", precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price", precision = 10, scale = 4)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 50, nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "order_placed_at")
    private LocalDateTime orderPlacedAt;

    @Column(name = "order_delivered_at")
    private LocalDateTime orderDeliveredAt;
}
