package com.Laptop.Purchase.controller;

import com.Laptop.Purchase.LaptopDetails;
import com.Laptop.Purchase.OrderDetails;
import com.Laptop.Purchase.OrderEmailRequest;
import com.Laptop.Purchase.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/send-order-email")
    public void sendOrderEmail(@RequestBody OrderEmailRequest request) {
        String to = request.getEmail();
        String subject = "Order Confirmation";
        String text = buildOrderEmailText(request.getOrderDetails());
        emailService.sendOrderConfirmationEmail(to, subject, text);
    }

    private String buildOrderEmailText(OrderDetails orderDetails) {
        // Build the email text based on the order details
        // You can customize this according to your needs
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append("Thank you for your order!\n\n");
        textBuilder.append("Order Details:\n");

        for (LaptopDetails laptop : orderDetails.getLaptops()) {
            textBuilder.append(String.format("%s - Quantity: %d - Price: $%.2f\n",
                    laptop.getModel(), laptop.getQuantity(), laptop.getPrice()));
        }

        textBuilder.append("\nTotal Price: $").append(orderDetails.getTotalPrice());

        return textBuilder.toString();
    }
}
