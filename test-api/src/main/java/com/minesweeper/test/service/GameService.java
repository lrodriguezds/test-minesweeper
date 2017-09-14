package com.minesweeper.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.minesweeper.test.domain.Game;
import com.minesweeper.test.domain.repository.GameConstants;
import com.minesweeper.test.domain.repository.GameRepository;
import com.minesweeper.test.dto.GameResponse;

/**
 * Game Service class is in charge of orchestrating the creation and retrieval
 * of a Game.
 * 
 */
@Service
public class GameService {

	private GameRepository gameRepository;
	
	
	@Inject
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	/**
	 * 
	 * @param createGameRequest
	 * @return
	 */
	public GameResponse createGame() {

		Game game = new Game();

		createBoard(game);

		gameRepository.save(game);

		return game.toResponse();
	}

	private void createBoard(Game game) {

		boolean[][] bombs = new boolean[GameConstants.ROWS + 2][GameConstants.COLS + 2];

		for (int i = 1; i <= GameConstants.ROWS; i++) {
			for (int j = 1; j <= GameConstants.COLS; j++) {
				bombs[i][j] = (Math.random() < GameConstants.BOMB_PROBABILITY);
			}
		}
		
		StringBuilder currentBoard = new StringBuilder();
		for (int i = 1; i <= GameConstants.ROWS; i++) {
			for (int j = 1; j <= GameConstants.COLS; j++) {
				currentBoard.append(" ,");	
			}
		}
		
		game.setCurrentBoard(currentBoard.toString());

		
		int[][] solution = new int[GameConstants.ROWS + 2][GameConstants.COLS + 2];

		for (int i = 1; i <= GameConstants.ROWS; i++) {
			for (int j = 1; j <= GameConstants.COLS; j++) {
				for (int ii = i - 1; ii <= i + 1; ii++) {
					for (int jj = j - 1; jj <= j + 1; jj++) {
						if (bombs[ii][jj]) {
							solution[i][j]++;
						}
					}
				}
			}
		}

		StringBuilder solutionBoard = new StringBuilder();
		for (int i = 1; i <= GameConstants.ROWS; i++) {
			for (int j = 1; j <= GameConstants.COLS; j++) {
				if (bombs[i][j]) {
					System.out.print("* ");
					solutionBoard.append(GameConstants.MINE + ",");
				} else {
					System.out.print(solution[i][j] + " ");
					solutionBoard.append(solution[i][j] + ",");
				}
			}
			System.out.println();
		}
		game.setSolutionBoard(solutionBoard.toString());

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GameResponse retrieveGame(Integer id) throws Exception {

		Game game = gameRepository.findOne(id);

		if (game == null) {
			throw new Exception("Game not found");
		}

		return game.toResponse();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<GameResponse> retrieveGameList() throws Exception {

		Iterable<Game> games = gameRepository.findAll();

		List<GameResponse> gamesResponse = new ArrayList<>();

		Iterator<Game> gameIterator = games.iterator();
		while (gameIterator.hasNext()) {
			Game game = gameIterator.next();
			gamesResponse.add(game.toResponse());
		}

		return gamesResponse;
	}

}
