package com.example.projekat.config;


import com.example.projekat.model.*;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Component
public class ApplicationScopeStorage {

    private final List<VideoGame> games = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Rating> ratings = new ArrayList<>();

    @PostConstruct
    public void init() {
        games.add(new VideoGame(1, "The Witcher 3", "RPG", "PC", "Epic fantasy RPG"));
        games.add(new VideoGame(2, "God of War", "Action", "PS5", "Action game"));
    }

    public List<VideoGame> getGames() { return games; }
    public List<Comment> getComments() { return comments; }
    public List<Rating> getRatings() { return ratings; }
}
