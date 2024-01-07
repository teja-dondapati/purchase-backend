package com.Laptop.Purchase.service;

import com.Laptop.Purchase.entity.Laptop;
import com.Laptop.Purchase.entity.Purchase;
import com.Laptop.Purchase.repository.LaptopRepository;
import com.Laptop.Purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final LaptopRepository laptopRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, LaptopRepository laptopRepository) {
        this.purchaseRepository = purchaseRepository;
        this.laptopRepository = laptopRepository;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public Purchase makePurchase(Purchase purchase) {
        long customerId = purchase.getCustomer().getId();
        int laptopId = purchase.getLaptopId();
        int quantity = purchase.getQuantity();
        String couponCode = purchase.getCouponCode();

        // Implement the business logic for making a purchase
        int purchasedQuantityForModel = purchaseRepository.getTotalPurchasedQuantityForModel(customerId, laptopId);
        if (purchasedQuantityForModel + quantity > 2) {
            // Handle the case where the customer exceeds the limit
            // You can throw an exception or handle it based on your requirements
        }

        double totalPrice = calculateTotalPrice(laptopId, quantity);
        double discountedPrice = applyDiscounts(totalPrice, quantity, couponCode);

        purchase.setTotalAmount(discountedPrice);
        updateInventory(laptopId, quantity);
        purchaseRepository.save(purchase);
        sendEmailConfirmation(customerId, purchase.getId());

        return purchase;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public List<Purchase> getPurchasesByCustomerId(Long customerId) {
        return purchaseRepository.findByCustomerId(customerId);
    }

    public List<Purchase> getPurchasesByLaptopId(Long laptopId) {
        return purchaseRepository.findByLaptopId(laptopId);
    }

    public BigDecimal getTotalAmountByCustomerId(Long customerId) {
        return purchaseRepository.calculateTotalAmountByCustomerId(customerId);
    }

    private double calculateTotalPrice(int laptopId, int quantity) {
        double laptopPrice = 1000.0; // Replace with actual logic to get laptop price
        return laptopPrice * quantity;
    }



    private double applyDiscounts(double totalPrice, int quantity, String couponCode) {
        if ("NEWYEAR".equals(couponCode)) {
            return (quantity == 2) ? totalPrice * 0.6 : totalPrice * 0.75;
        } else {
            return totalPrice;
        }
    }

    private void updateInventory(int laptopId, int quantity) {
        // Implement logic to update inventory in the database or another source
        // For simplicity, not implementing the actual update logic here
        System.out.println("Updating inventory for laptopId: " + laptopId + ", Quantity: " + quantity);
    }

    private void sendEmailConfirmation(long customerId, Long purchaseId) {
        // Implement logic to send email confirmation to the customer
        // You may use a service like JavaMailSender or another email service
        System.out.println("Sending email confirmation to customer " + customerId + " for purchase ID " + purchaseId);
    }
}
