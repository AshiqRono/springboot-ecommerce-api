package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.ProductwiseOrderHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductwiseOderHistoryRepository extends JpaRepository<ProductwiseOrderHistory, Long> {

    @Query("SELECT p.productId, p.productName, SUM(p.totalPrice) as totalSales " +
            "FROM ProductwiseOrderHistory p " +
            "GROUP BY p.productId, p.productName " +
            "ORDER BY totalSales DESC")
    List<Object[]> findTopProductsBySales(Pageable pageable);

    @Query("SELECT p.productId, p.productName, SUM(p.quantity) as totalQuantity " +
            "FROM ProductwiseOrderHistory p " +
            "GROUP BY p.productId, p.productName " +
            "ORDER BY totalQuantity DESC")
    List<Object[]> findTopProductsByQuantity(Pageable pageable);

}
