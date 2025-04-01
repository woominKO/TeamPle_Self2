package com.example.TeamPle_Self2.controller;

import com.example.TeamPle_Self2.dto.CreateRoomRequest;
import com.example.TeamPle_Self2.dto.RoomResponseDto;
import com.example.TeamPle_Self2.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamPleController {

    private final RoomService roomService;

    @PostMapping("/api/rooms")
    public RoomResponseDto room(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }
}
