package com.minesweeper.test.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.minesweeper.test.domain.repository.GameRepository;

/**
 * Play Service class is in charge of orchestrating the game play.
 * 
 */
@Service
public class PlayService {

	private GameRepository gameRepository;
	
	private final GameService gameService;
	
	
	@Inject
	public PlayService(GameRepository gameRepository, GameService gameService) {
		this.gameRepository = gameRepository;
		this.gameService = gameService;
	}

}
