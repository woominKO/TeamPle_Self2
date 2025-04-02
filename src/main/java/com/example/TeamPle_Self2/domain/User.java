package com.example.TeamPle_Self2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String roleTag;

    private boolean isAccepted;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    public User() {
    }

    public User(String username, String roleTag, boolean isAccepted){
        this.username= username;
        this.roleTag = roleTag;
        this.isAccepted = isAccepted;

    }
}
