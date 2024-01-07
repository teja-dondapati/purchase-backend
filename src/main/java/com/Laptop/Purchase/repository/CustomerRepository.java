package com.Laptop.Purchase.repository;


import com.Laptop.Purchase.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Add custom query methods if needed
}
