package com.example.TeamPle_Self2.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {
    private UUID roomId;
    private String roomName;
    private LocalDateTime createdAt;
}
