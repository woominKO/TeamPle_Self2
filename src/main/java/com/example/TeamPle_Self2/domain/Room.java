package com.example.TeamPle_Self2.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Setter
public class Room {
    @Id
    private UUID roomId;
    private String roomName;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "room", cascade =  CascadeType.ALL)
    private List<User> users =  new ArrayList<>();

    public Room() {}


    public Room(String roomName) {
        this.roomId = UUID.randomUUID();
        this.roomName = roomName;
        this.createdAt = LocalDateTime.now();
    }
}


