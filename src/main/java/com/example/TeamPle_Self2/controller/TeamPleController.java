package com.example.TeamPle_Self2.controller;

import com.example.TeamPle_Self2.domain.User;
import com.example.TeamPle_Self2.dto.CreateRoomRequest;
import com.example.TeamPle_Self2.dto.JoinReq;
import com.example.TeamPle_Self2.dto.RoomResponseDto;
import com.example.TeamPle_Self2.dto.UserRes;
import com.example.TeamPle_Self2.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TeamPleController {

    private final RoomService roomService;

    @PostMapping("/api/rooms")
    public RoomResponseDto room(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }

    @PostMapping("/api/rooms/{roomId}")
    public ResponseEntity<UserRes> Join(@RequestBody JoinReq req, @PathVariable UUID roomId){
        UserRes user = roomService.JoinRoom(req,roomId);
        String roomName = roomService.getRoomNameByRoomId(roomId);
        return ResponseEntity.ok(user);
    }

}
