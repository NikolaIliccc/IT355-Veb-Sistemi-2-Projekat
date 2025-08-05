package com.example.projekat.config;

import com.example.projekat.model.Comment;
import com.example.projekat.model.Rating;
import com.example.projekat.model.VideoGame;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationScopeStorage {

    private final List<VideoGame> games = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Rating> ratings = new ArrayList<>();

    @PostConstruct
    public void init() {
        games.add(new VideoGame(1, "The Witcher 3", "RPG", "PC", "Epic fantasy RPG"));
        games.add(new VideoGame(2, "God of War", "Action", "PS5", "Action game"));
        games.add(new VideoGame(3, "Hollow Knight", "Platformer", "PC", "Challenging Metroidvania adventure"));
        games.add(new VideoGame(4, "Elden Ring", "RPG", "PC", "Open-world soulslike experience"));
        games.add(new VideoGame(5, "Forza Horizon 5", "Racing", "Xbox", "Open-world racing across Mexico"));
        games.add(new VideoGame(6, "Stardew Valley", "Simulation", "PC", "Farming and life simulator"));
        games.add(new VideoGame(7, "Minecraft", "Sandbox", "PC", "Build, explore, survive"));
        games.add(new VideoGame(8, "Cyberpunk 2077", "RPG", "PC", "Futuristic open-world RPG"));
    }

    public List<VideoGame> getGames() {
        return games;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
}
