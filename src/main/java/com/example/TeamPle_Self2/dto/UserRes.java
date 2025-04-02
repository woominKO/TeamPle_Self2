package com.example.TeamPle_Self2.dto;

import com.example.TeamPle_Self2.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRes {
    private Long id;
    private String username;
    private String roleTag;
    private boolean accepted;
    private UUID roomId; // 단순 정보만

    public UserRes(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roleTag = user.getRoleTag();
        this.accepted = user.isAccepted();
        this.roomId = user.getRoom().getRoomId();
    }
}
