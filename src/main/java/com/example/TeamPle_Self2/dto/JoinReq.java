package com.example.TeamPle_Self2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinReq {
    private String username;
    private String roleTag;
    private boolean isAccepted;

}
