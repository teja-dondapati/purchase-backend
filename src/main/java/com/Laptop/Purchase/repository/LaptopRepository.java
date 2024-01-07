package com.Laptop.Purchase.repository;

import com.Laptop.Purchase.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    // Add custom query methods if needed
}
