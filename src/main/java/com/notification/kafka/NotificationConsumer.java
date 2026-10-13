package com.notification.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.model.Order;
import com.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;
    
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "orders", groupId = "notification-group-RAVI-FINAL")
    public void consume(String message) {
        try {
            System.out.println("========================================");
            System.out.println(">>> [79-NOTIFICATION] RAW MESSAGE: " + message);
            Order order = mapper.readValue(message, Order.class);
            System.out.println(">>> [79-NOTIFICATION] CONSUMED Event: " + order);
            System.out.println(">>> Product: " + order.getProduct() + " Qty: " + order.getQty());
            System.out.println("========================================");
            notificationService.sendNotification(order);
        } catch (Exception e) {
            System.err.println("Failed to parse: " + e.getMessage());
            e.printStackTrace();
        }
    }
}