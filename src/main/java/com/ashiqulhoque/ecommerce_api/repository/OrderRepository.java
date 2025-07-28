package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT DATE(o.orderPlacedAt) as orderDate, SUM(o.totalAmount) as totalSales " +
            "FROM Orders o " +
            "WHERE DATE(o.orderPlacedAt) = :startDate " +
            "AND o.orderStatus IN ( 'DELIVERED' , 'SHIPPED' ) " +
            "GROUP BY DATE(o.orderPlacedAt)")
    List<Object[]> findTotalSaleOfTheDay(@Param("startDate") LocalDate startDate);


    @Query("SELECT DATE(o.orderPlacedAt) as orderDate, SUM(o.totalAmount) as totalSales " +
            "FROM Orders o " +
            "WHERE Date(o.orderPlacedAt) BETWEEN :startDate AND :endDate " +
            "AND o.orderStatus IN ( 'DELIVERED' , 'SHIPPED' ) " +
            "GROUP BY DATE(o.orderPlacedAt) " +
            "ORDER BY totalSales DESC")
    List<Object[]> findMaxSalesPerDay(@Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);

}
