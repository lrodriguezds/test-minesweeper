package com.minesweeper.test.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.minesweeper.test.domain.Game;
import com.minesweeper.test.domain.repository.GameConstants;
import com.minesweeper.test.domain.repository.GameRepository;
import com.minesweeper.test.dto.GameResponse;

/**
 * Play Service class is in charge of orchestrating the game play.
 * 
 */
@Service
public class PlayService {

	private GameRepository gameRepository;

	@Inject
	public PlayService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	/**
	 * Method that sweep a cell. Should validate the input and determine if win
	 * or lost the game.
	 * 
	 * @param gameId
	 * @param row
	 * @param col
	 * @return an updated game with a fresh board
	 * @throws Exception
	 */
	public GameResponse play(Integer gameId, Integer row, Integer col) throws Exception {

		checkColAndRow(row, col);

		Game game = gameRepository.findOne(gameId);

		Integer position = (row - 1) * GameConstants.ROWS + col;

		String cellDiscovered = game.sweepCell(position);

		if (cellDiscovered.equals(GameConstants.MINE)) {
			game.gameOver();
		} else {
			game.updateCurrentBoard(position);

			if (game.getCurrentBoard().toString().equals(game.getSolutionBoard().toString())) {
				game.win();
			}
		}
		game = gameRepository.save(game);

		return game.toResponse();
	}

	private void checkColAndRow(Integer row, Integer col) throws Exception {

		if (col <= 0 || col > GameConstants.COLS || row <= 0
				|| row > GameConstants.ROWS) {

			// TODO Improve Exception handling
			throw new Exception("Col/Row has invalid value");
		}

	}

}
