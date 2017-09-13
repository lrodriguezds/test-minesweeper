package com.minesweeper.test.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minesweeper.test.service.GameService;
import com.minesweeper.test.service.PlayService;

/**
 * Play API controller. In charge of receiving the HTTP requests and delegating all them to the PlayService class.
 */
@RestController
@RequestMapping("/play")
public class PlayController {
	
	private final PlayService playService;
	private final GameService gameService;
    
    @Inject
    public PlayController(PlayService playService, GameService gameService) {
        this.playService = playService;
        this.gameService = gameService;
    }
    

}
