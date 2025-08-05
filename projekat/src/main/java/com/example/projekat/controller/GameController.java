package com.example.projekat.controller;

import com.example.projekat.model.VideoGame;
import com.example.projekat.model.Comment;
import com.example.projekat.model.Rating;
import com.example.projekat.service.GameService;
import com.example.projekat.service.CommentService;
import com.example.projekat.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;
    private final CommentService commentService;
    private final RatingService ratingService;

    public GameController(GameService gameService, CommentService commentService, RatingService ratingService) {
        this.gameService = gameService;
        this.commentService = commentService;
        this.ratingService = ratingService;
    }

    @GetMapping
    public String listGames(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "game/list";
    }

    @GetMapping("/{id}")
    public String viewGame(@PathVariable int id, Model model) {
        VideoGame game = gameService.findById(id).orElse(null);
        if (game == null) {
            return "redirect:/games";
        }

        model.addAttribute("game", game);
        model.addAttribute("comments", commentService.getCommentsForGame(id));
        model.addAttribute("averageRating", ratingService.getAverageRating(id));
        model.addAttribute("newComment", new Comment());
        model.addAttribute("newRating", new Rating());
        return "game/detail";
    }

    @GetMapping("/add")
    public String addGameForm(Model model) {
        model.addAttribute("game", new VideoGame());
        return "game/add";
    }

    @PostMapping("/add")
    public String addGame(@ModelAttribute VideoGame game) {
        gameService.addGame(game);
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String editGameForm(@PathVariable int id, Model model) {
        model.addAttribute("game", gameService.findById(id).orElse(null));
        return "game/edit";
    }

    @PostMapping("/edit")
    public String editGame(@ModelAttribute VideoGame game) {
        gameService.updateGame(game);
        return "redirect:/games";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
        return "redirect:/games";
    }

    @PostMapping("/{id}/comment")
    public String addComment(@PathVariable int id, @ModelAttribute Comment comment) {
        comment.setGameId(id);
        commentService.addComment(comment);
        return "redirect:/games/" + id;
    }

    @PostMapping("/{id}/rating")
    public String addRating(@PathVariable int id, @ModelAttribute Rating rating) {
        rating.setGameId(id);
        ratingService.addRating(rating);
        return "redirect:/games/" + id;
    }
}
