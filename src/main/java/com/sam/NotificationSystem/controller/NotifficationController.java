package com.sam.NotificationSystem.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotifficationController {

    // This method is used to send the message to the server
    ///app/sendNotification
    @MessageMapping("/sendNotification")
    @SendTo("/topic/notifications")
    public String sendNotification(String message) {
        System.out.println("Notification sent: " + message);
        return "Notification sent: " + message;
    }

}
