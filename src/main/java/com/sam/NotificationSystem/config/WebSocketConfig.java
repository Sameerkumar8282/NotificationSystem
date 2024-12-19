package com.sam.NotificationSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    
    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry config) {
        //for broadcasting
        config.enableSimpleBroker("/topic");
        //for sending message to the server and then to the client to access the message
        config.setApplicationDestinationPrefixes("/app");
        //topic/cricket
        //topic/order
    }

    @Override
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
        //for connecting to the server client uses this endpoint to connect
        registry.addEndpoint("/ws")
        .setAllowedOriginPatterns("*")
        .withSockJS();
    }
}
