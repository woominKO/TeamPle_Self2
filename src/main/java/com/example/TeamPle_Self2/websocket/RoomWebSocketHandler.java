
package com.example.TeamPle_Self2.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RoomWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, List<WebSocketSession>> roomSessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String roomId = getRoomId(session);
        String username = getUsername(session);

        session.getAttributes().put("roomId", roomId);
        session.getAttributes().put("username", username);

        roomSessions.computeIfAbsent(roomId, k -> new ArrayList<>()).add(session);

        broadcastUserList(roomId);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String roomId = (String) session.getAttributes().get("roomId");
        roomSessions.getOrDefault(roomId, new ArrayList<>()).remove(session);

        broadcastUserList(roomId);
    }

    private void broadcastUserList(String roomId) throws Exception {
        List<WebSocketSession> sessions = roomSessions.getOrDefault(roomId, List.of());

        List<String> usernames = sessions.stream()
                .map(s -> (String) s.getAttributes().get("username"))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        String json = objectMapper.writeValueAsString(Map.of("users", usernames));

        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage(json));
            }
        }
    }

    private String getRoomId(WebSocketSession session) {
        URI uri = session.getUri();
        if (uri != null) {
            String[] parts = uri.getPath().split("/");
            return parts.length >= 4 ? parts[3] : "default";
        }
        return "default";
    }

    private String getUsername(WebSocketSession session) {
        URI uri = session.getUri();
        if (uri != null && uri.getQuery() != null) {
            for (String param : uri.getQuery().split("&")) {
                if (param.startsWith("username=")) {
                    return param.substring("username=".length());
                }
            }
        }
        return "익명";
    }
}
