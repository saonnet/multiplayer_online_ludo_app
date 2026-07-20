package com.saonnet.ludo.leaderboard.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("ludo:user")
@Data
public class User implements Serializable {

    private String id;
    private String username;
    private String profilePictureUrl;
    private int rank;
    private int score;
}
