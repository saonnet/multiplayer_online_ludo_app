package com.saonnet.ludo.leaderboard.controller;

import com.saonnet.ludo.dto.AddScoreDTO;
import com.saonnet.ludo.leaderboard.service.LeaderboardTimeType;
import com.saonnet.ludo.leaderboard.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class SimpleController {

    private RedisService redisService;

    @Autowired
    public SimpleController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/add")
    public String addScore(@RequestBody AddScoreDTO requestBody) {
        if(requestBody.getUserId() != null) {
            redisService.addScore(
                    System.currentTimeMillis(),
                    LeaderboardTimeType.DAY,
                    requestBody.getUserId(),
                    5);

            return requestBody.getUserId() + " score incremented!";
        } else {
            return "User id musn't be null";
        }
    }

    @GetMapping("/leaderboard/{type}")
    public Map<String, Double> getLeaderboard(@PathVariable String type) {
        if(type.equalsIgnoreCase("day")) {
            return redisService.getCurrentTopPlayersWithScore(LeaderboardTimeType.DAY, 0, 10);
        }

        return Collections.emptyMap();
    }
}
