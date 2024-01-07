package com.Laptop.Purchase;


// OrderEmailRequest.java
public class OrderEmailRequest {
    private String email;
    private OrderDetails orderDetails;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
