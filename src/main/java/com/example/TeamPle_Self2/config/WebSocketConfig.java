package com.example.TeamPle_Self2.config;

import com.example.TeamPle_Self2.websocket.RoomWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new RoomWebSocketHandler(), "/ws/rooms/{roomId}")
                .setAllowedOrigins("*");
    }
}