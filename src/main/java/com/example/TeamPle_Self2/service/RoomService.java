package com.example.TeamPle_Self2.service;
import com.example.TeamPle_Self2.domain.Room;
import com.example.TeamPle_Self2.dto.CreateRoomRequest;
import com.example.TeamPle_Self2.dto.JoinReq;
import com.example.TeamPle_Self2.dto.RoomResponseDto;
import com.example.TeamPle_Self2.dto.UserRes;
import com.example.TeamPle_Self2.repository.RoomRepository;
import com.example.TeamPle_Self2.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.stereotype.Service;
import com.example.TeamPle_Self2.domain.User;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class RoomService {
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public RoomResponseDto createRoom(CreateRoomRequest requestDto) {
        // 생성자 통해 createdAt 설정됨
        Room room = new Room(requestDto.getRoomName());

        // 저장
        roomRepository.save(room);

        // 응답 DTO에 생성된 Room 정보 담아서 리턴
        return new RoomResponseDto(
                room.getRoomId(),
                room.getRoomName(),
                room.getCreatedAt()
        );
    }

    public String getRoomNameByRoomId(UUID roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return room.getRoomName();
    }


    public UserRes JoinRoom(JoinReq req, UUID roomId){
        // 1. 방 조회
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("방이 존재하지 않습니다."));

        // 2. 유저 생성
        User user = new User(req.getUsername(), req.getRoleTag(), req.isAccepted());


        // 3. 방과 연관관계 설정
        user.setRoom(room);

        // 4. 저장
        User savedUser = userRepository.save(user);

        return new UserRes(savedUser, room.getRoomName());

    }}