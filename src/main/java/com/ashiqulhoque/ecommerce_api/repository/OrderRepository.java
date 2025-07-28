package com.ashiqulhoque.ecommerce_api.repository;

import com.ashiqulhoque.ecommerce_api.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT CAST(o.orderPlacedAt as date ) as orderDate, SUM(o.totalAmount) as totalSales " +
            "FROM Orders o " +
            "WHERE CAST(o.orderPlacedAt as date) = :startDate " +
            "AND o.orderStatus IN ( 'DELIVERED' , 'SHIPPED' ) " +
            "GROUP BY CAST(o.orderPlacedAt as date )")
    List<Object[]> findTotalSaleOfTheDay(@Param("startDate") LocalDate startDate);


    @Query("SELECT CAST(o.orderPlacedAt as date) as orderDate, SUM(o.totalAmount) as totalSales " +
            "FROM Orders o " +
            "WHERE CAST(o.orderPlacedAt as date) BETWEEN :startDate AND :endDate " +
            "AND o.orderStatus IN ( 'DELIVERED' , 'SHIPPED' ) " +
            "GROUP BY CAST(o.orderPlacedAt as date) " +
            "ORDER BY totalSales DESC")
    List<Object[]> findMaxSalesPerDay(@Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);

}
