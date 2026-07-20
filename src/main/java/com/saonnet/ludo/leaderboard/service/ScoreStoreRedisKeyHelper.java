package com.saonnet.ludo.leaderboard.service;

import org.springframework.stereotype.Service;

import static com.saonnet.ludo.leaderboard.service.LeaderboardTimeType.*;

public class ScoreStoreRedisKeyHelper {

    private static String getLeaderboardKeyByDayBasedOnTimestamp(long timestamp) {
        long startOfDayTimestamp = TimeUtil.getStartOfDayTimestamp(timestamp);
        long endOfDayTimestamp = TimeUtil.getEndOfDayTimestamp(timestamp);
        return "leaderboard:day:" + startOfDayTimestamp + ":" + endOfDayTimestamp;
    }

    private static String getLeaderboardKeyByWeekBasedOnTimestamp(long timestamp) {
        long startOfWeekTimestamp = TimeUtil.getStartOfWeekTimestamp(timestamp);
        long endOfWeekTimestamp = TimeUtil.getEndOfWeekTimestamp(timestamp);
        return "leaderboard:week:" + startOfWeekTimestamp + ":" + endOfWeekTimestamp;
    }

    private static String getLeaderboardKeyByMonthBasedOnTimestamp(long timestamp) {
        long startOfMonthTimestamp = TimeUtil.getStartOfMonthTimestamp(timestamp);
        long endOfMonthTimestamp = TimeUtil.getEndOfMonthTimestamp(timestamp);
        return "leaderboard:month:" + startOfMonthTimestamp + ":" + endOfMonthTimestamp;
    }

    private static String getLeaderboardKeyByYearBasedOnTimestamp(long timestamp) {
        long startOfYearTimestamp = TimeUtil.getStartOfYearTimestamp(timestamp);
        long endOfYearTimestamp = TimeUtil.getEndOfYearTimestamp(timestamp);
        return "leaderboard:year:" + startOfYearTimestamp + ":" + endOfYearTimestamp;
    }

    public static String getLeaderboardKeyBasedOnTimestamp(long timestamp, LeaderboardTimeType timeType) {
        return switch (timeType) {
            case DAY -> getLeaderboardKeyByDayBasedOnTimestamp(timestamp);
            case WEEK -> getLeaderboardKeyByWeekBasedOnTimestamp(timestamp);
            case MONTH -> getLeaderboardKeyByMonthBasedOnTimestamp(timestamp);
            case YEAR -> getLeaderboardKeyByYearBasedOnTimestamp(timestamp);
            case ALL -> "leaderboard:all";
        };
    }

}
