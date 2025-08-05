package com.example.projekat.service;

import com.example.projekat.config.ApplicationScopeStorage;
import com.example.projekat.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final ApplicationScopeStorage storage;

    public CommentService(ApplicationScopeStorage storage) {
        this.storage = storage;
    }

    public void addComment(Comment comment) {
        storage.getComments().add(comment);
    }

    public List<Comment> getCommentsForGame(int gameId) {
        return storage.getComments().stream()
                .filter(c -> c.getGameId() == gameId)
                .collect(Collectors.toList());
    }
}
