package com.tiendaonline.tiendabackend.controller;

import com.tiendaonline.tiendabackend.exception.GameNotFoundException;
import com.tiendaonline.tiendabackend.model.Game;
import com.tiendaonline.tiendabackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/game")
    Game newGame(@RequestBody Game newGame) {
        return gameRepository.save(newGame);
    }

    @GetMapping("/games")
    List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/game/{id}")
    Game getGameById(@PathVariable Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @PutMapping("/game/{id}")
    Game updateGame(@RequestBody Game newGame, @PathVariable Long id) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setNombre(newGame.getNombre());
                    game.setDescripcion(newGame.getDescripcion());
                    game.setPeso(newGame.getPeso());
                    game.setIdioma(newGame.getIdioma());
                    game.setPrecio(newGame.getPrecio());
                    game.setConsola(newGame.getConsola());
                    game.setImguno(newGame.getImguno());
                    game.setImgdos(newGame.getImgdos());
                    game.setImgtres(newGame.getImgtres());
                    game.setStock(newGame.getStock());
                    game.setGenero(newGame.getGenero());
                    game.setLanzamiento(newGame.getLanzamiento());
                    game.setVersion(newGame.getVersion());
                    game.setVideo(newGame.getVideo());
                    return gameRepository.save((game));
                }).orElseThrow(()->new GameNotFoundException(id));
    }

    @DeleteMapping("/game/{id}")
    String deleteGame(@PathVariable Long id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id);
        return "Game con id " + id + " ha sido eliminado correctamente";
    }

}
