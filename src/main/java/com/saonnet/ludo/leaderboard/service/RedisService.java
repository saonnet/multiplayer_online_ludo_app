package com.saonnet.ludo.leaderboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisService {

    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addScore(long timestamp, LeaderboardTimeType timeType, String playerId, int score) {
        String leaderBoardKey = ScoreStoreRedisKeyHelper.getLeaderboardKeyBasedOnTimestamp(timestamp, timeType);
        redisTemplate.opsForZSet().incrementScore(leaderBoardKey, playerId, score);
    }

    public List<String> getCurrentTopPlayers(LeaderboardTimeType timeType, int start, int end) {
        String leaderboardKey = ScoreStoreRedisKeyHelper.getLeaderboardKeyBasedOnTimestamp(System.currentTimeMillis(), timeType);
        Set<String> leaderboard = redisTemplate.opsForZSet().reverseRange(leaderboardKey, start, end);
        return leaderboard != null ? List.copyOf(leaderboard) : Collections.emptyList();
    }

    public Map<String, Double> getCurrentTopPlayersWithScore(LeaderboardTimeType timeType, int start, int end) {
        String leaderboardKey = ScoreStoreRedisKeyHelper.getLeaderboardKeyBasedOnTimestamp(System.currentTimeMillis(), timeType);
        Set<ZSetOperations.TypedTuple<String>> leaderboard = redisTemplate.opsForZSet().reverseRangeWithScores(leaderboardKey, start, end);

        Map<String, Double> leaderboardWithScore = new LinkedHashMap<>();
        if(leaderboard != null) {
            for(ZSetOperations.TypedTuple<String> entry : leaderboard) {
                if(entry.getValue() != null && entry.getScore() != null) {
                    leaderboardWithScore.put(entry.getValue(), entry.getScore());
                }
            }
        }

        return leaderboardWithScore;
    }

    public Long getScoreForPlayer(LeaderboardTimeType timeType, String playerId) {
        String leaderboardKey = ScoreStoreRedisKeyHelper.getLeaderboardKeyBasedOnTimestamp(System.currentTimeMillis(), timeType);
        Long rank = redisTemplate.opsForZSet().rank(leaderboardKey, playerId);

        if(rank != null) {
            return rank + 1;
        }

        return null;
    }

    // this would be a batched/pipeline operation in real world
    // and will accept a list of player id's and return the data as a list
    // instead of working on individual player id's
    public String getPlayer(String playerId) {
        Object user = redisTemplate.opsForHash().get("leaderboard:user", playerId);
        return (String) user;
    }
}
