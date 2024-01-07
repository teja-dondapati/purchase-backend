package com.Laptop.Purchase;

// OrderDetails.java
import java.util.List;

public class OrderDetails {
    private List<LaptopDetails> laptops;
    private double totalPrice;

    public List<LaptopDetails> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<LaptopDetails> laptops) {
        this.laptops = laptops;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
