package com.example.projekat.service;

import com.example.projekat.config.ApplicationScopeStorage;
import com.example.projekat.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final ApplicationScopeStorage storage;

    public RatingService(ApplicationScopeStorage storage) {
        this.storage = storage;
    }

    public void addRating(Rating rating) {
        storage.getRatings().add(rating);
    }

    public List<Rating> getRatingsForGame(int gameId) {
        return storage.getRatings().stream()
                .filter(r -> r.getGameId() == gameId)
                .collect(Collectors.toList());
    }

    public double getAverageRating(int gameId) {
        List<Rating> ratings = getRatingsForGame(gameId);
        if (ratings.isEmpty()) return 0;
        return ratings.stream().mapToInt(Rating::getScore).average().orElse(0);
    }
}
