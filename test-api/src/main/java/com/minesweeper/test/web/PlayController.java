package com.minesweeper.test.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minesweeper.test.dto.GameResponse;
import com.minesweeper.test.service.PlayService;

/**
 * Play API controller. In charge of receiving the HTTP requests and delegating
 * all them to the PlayService class.
 */
@RestController
@RequestMapping("/play")
@CrossOrigin(origins = "*/*/*")
public class PlayController {

	private final PlayService playService;

	@Inject
	public PlayController(PlayService playService) {
		this.playService = playService;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public GameResponse retrieveGame(@PathVariable(value = "id") Integer gameId, @RequestParam Integer row, @RequestParam Integer col)
			throws Exception {
		return playService.play(gameId, row, col);
	}

}
