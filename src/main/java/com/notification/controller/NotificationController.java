package com.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @GetMapping("/api/notifications")
    public String health() {
        return "79-notification-service RUNNING - Listening to orders topic!";
    }
}