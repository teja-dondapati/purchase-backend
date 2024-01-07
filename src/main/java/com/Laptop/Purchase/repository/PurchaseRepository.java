package com.Laptop.Purchase.repository;

import com.Laptop.Purchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByCustomerId(Long customerId);

    List<Purchase> findByLaptopId(Long laptopId);

    @Query("SELECT COALESCE(SUM(p.quantity), 0) FROM Purchase p " +
            "WHERE p.customer.id = :customerId AND p.laptopId = :laptopId")
    int getTotalPurchasedQuantityForModel(@Param("customerId") long customerId, @Param("laptopId") int laptopId);

    @Query("SELECT COALESCE(SUM(p.totalAmount), 0) FROM Purchase p WHERE p.customer.id = :customerId")
    BigDecimal calculateTotalAmountByCustomerId(@Param("customerId") Long customerId);
}
