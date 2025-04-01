package com.example.TeamPle_Self2.service;

import com.example.TeamPle_Self2.domain.Room;
import com.example.TeamPle_Self2.dto.CreateRoomRequest;
import com.example.TeamPle_Self2.dto.RoomResponseDto;
import com.example.TeamPle_Self2.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

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
}