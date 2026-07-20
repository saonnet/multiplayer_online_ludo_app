package com.saonnet.ludo.leaderboard.service;

public enum LeaderboardTimeType {

    DAY(0),
    WEEK(1),
    MONTH(2),
    YEAR(3),
    ALL(4);

    private int value;

    LeaderboardTimeType(int value) { this.value = value; }

    public int getValue() { return value;}
}
