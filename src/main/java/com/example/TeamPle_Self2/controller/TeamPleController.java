package com.example.TeamPle_Self2.controller;

import com.example.TeamPle_Self2.domain.User;
import com.example.TeamPle_Self2.dto.CreateRoomRequest;
import com.example.TeamPle_Self2.dto.JoinReq;
import com.example.TeamPle_Self2.dto.RoomResponseDto;
import com.example.TeamPle_Self2.dto.UserRes;
import com.example.TeamPle_Self2.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TeamPleController {

    private final RoomService roomService;

    @PostMapping("/api/rooms")
    public RoomResponseDto room(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }

    @PostMapping("/api/rooms/{roomId}")
    public ResponseEntity<UserRes> Join(@RequestBody JoinReq req, @PathVariable UUID roomId){
        UserRes user = roomService.JoinRoom(req,roomId);
        return ResponseEntity.ok(user);

    }
}
