package com.example.projekat.model;

public class VideoGame {
    private int id;
    private String title;
    private String genre;
    private String platform;
    private String description;

    public VideoGame() {}

    public VideoGame(int id, String title, String genre, String platform, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}