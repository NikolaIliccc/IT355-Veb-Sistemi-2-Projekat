package com.example.projekat.model;
public class Rating {
    private int gameId;
    private String username;
    private int score;

    public Rating() {}

    public Rating(int gameId, String username, int score) {
        this.gameId = gameId;
        this.username = username;
        this.score = score;
    }

    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
