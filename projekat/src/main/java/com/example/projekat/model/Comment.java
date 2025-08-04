package com.example.projekat.model;

public class Comment {
    private int gameId;
    private String username;
    private String content;

    public Comment() {}

    public Comment(int gameId, String username, String content) {
        this.gameId = gameId;
        this.username = username;
        this.content = content;
    }

    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
