package com.example.TeamPle_Self2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest {
    private String roomName;
    private LocalDateTime createdAt;
}