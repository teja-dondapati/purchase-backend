package com.Laptop.Purchase.service;



import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    // Dummy method to get the price of a laptop
    public double getLaptopPrice(int laptopId) {
        // You may retrieve the price from the database or another source
        // For simplicity, returning a hardcoded value
        return 1000.0;
    }

    // Dummy method to update inventory
    public void updateInventory(int laptopId, int quantity) {
        // Business logic to update inventory
        // You may decrement the quantity in the database or another source
        // For simplicity, not implementing the actual update logic here
        System.out.println("Updating inventory for laptopId: " + laptopId + ", Quantity: " + quantity);
    }
}
