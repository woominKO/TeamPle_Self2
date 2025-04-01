package com.example.TeamPle_Self2.repository;

import com.example.TeamPle_Self2.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}