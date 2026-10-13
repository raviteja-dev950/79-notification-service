package com.notification.service;

import com.notification.model.Order;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(Order order) {
        System.out.println("********** NOTIFICATION SENT **********");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Product: " + order.getProduct());
        System.out.println("Quantity: " + order.getQty());
        System.out.println("Email sent to customer for order " + order.getId());
        System.out.println("***************************************");
    }
}