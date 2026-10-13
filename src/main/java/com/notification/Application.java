package com.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("79-notification-service RUNNING on 8088 - Listening to orders topic!");
        System.out.println("Consumer Group: notification-group - Topic: orders");
        System.out.println("Health: http://localhost:8088/api/notifications");
    }
}