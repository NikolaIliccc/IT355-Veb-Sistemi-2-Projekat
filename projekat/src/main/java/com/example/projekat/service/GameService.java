package com.example.projekat.service;

import com.example.projekat.config.ApplicationScopeStorage;
import com.example.projekat.model.VideoGame;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final ApplicationScopeStorage storage;

    public GameService(ApplicationScopeStorage storage) {
        this.storage = storage;
    }

    public List<VideoGame> findAll() {
        return storage.getGames();
    }

    public Optional<VideoGame> findById(int id) {
        return storage.getGames().stream().filter(g -> g.getId() == id).findFirst();
    }

    public void addGame(VideoGame game) {
        storage.getGames().add(game);
    }

    public void deleteGame(int id) {
        storage.getGames().removeIf(g -> g.getId() == id);
    }

    public void updateGame(VideoGame game) {
        deleteGame(game.getId());
        addGame(game);
    }
}
