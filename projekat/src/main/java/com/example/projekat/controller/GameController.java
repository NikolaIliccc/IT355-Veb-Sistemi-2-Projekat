package com.example.projekat.controller;

import com.example.projekat.model.VideoGame;
import com.example.projekat.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String listGames(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "game/list";
    }

    @GetMapping("/{id}")
    public String viewGame(@PathVariable int id, Model model) {
        model.addAttribute("game", gameService.findById(id).orElse(null));
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
}
