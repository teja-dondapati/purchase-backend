package com.Laptop.Purchase.controller;

import com.Laptop.Purchase.entity.Purchase;
import com.Laptop.Purchase.service.PurchaseService;
import com.Laptop.Purchase.entity.Customer;
import com.Laptop.Purchase.entity.Laptop;
import com.Laptop.Purchase.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/purchases")

public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping
    public Purchase makePurchase(@RequestBody Purchase purchase) {
        return purchaseService.makePurchase(purchase);
    }

    @GetMapping("/customer/{customerId}")
    public List<Purchase> getPurchasesByCustomerId(@PathVariable Long customerId) {
        return purchaseService.getPurchasesByCustomerId(customerId);
    }

    @GetMapping("/laptops")
    public List<Laptop> getAllLaptops() {
        return purchaseService.getAllLaptops();
    }

    @GetMapping("/laptop/{laptopId}")
    public List<Purchase> getPurchasesByLaptopId(@PathVariable Long laptopId) {
        return purchaseService.getPurchasesByLaptopId(laptopId);
    }

    @GetMapping("/customer/{customerId}/total")
    public BigDecimal getTotalAmountByCustomerId(@PathVariable Long customerId) {
        return purchaseService.getTotalAmountByCustomerId(customerId);
    }


}
