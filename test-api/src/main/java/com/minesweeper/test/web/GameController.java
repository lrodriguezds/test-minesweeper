package com.minesweeper.test.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minesweeper.test.dto.CreateGameRequest;
import com.minesweeper.test.dto.GameResponse;
import com.minesweeper.test.service.GameService;

/**
 * Game API controller. In charge of receiving the HTTP requests and delegating all them to the GameService class.
 */
@RestController
@RequestMapping("/game")
public class GameController {
	
	private final GameService gameService;
    
    @Inject
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody GameResponse createGame() throws Exception {
    	return gameService.createGame();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<GameResponse> retrieveGameList() throws Exception {
        return gameService.retrieveGameList();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody GameResponse retrieveGame(@PathVariable(value="id") Integer id) throws Exception {
        return gameService.retrieveGame(id);
    }
    

}
