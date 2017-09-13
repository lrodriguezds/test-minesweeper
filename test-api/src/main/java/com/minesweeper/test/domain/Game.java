package com.minesweeper.test.domain;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.minesweeper.test.dto.GameResponse;

/**
 * Game Entity class used to hold information associated with a game.
 *
 */
@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "current_board", nullable = false)
	private String currentBoard;

	@Column(name = "solution_board", nullable = false)
	private String solutionBoard;

	@Column(name = "startedOn")
	private LocalTime startedOn;

	@Column(name = "finishedOn")
	private LocalTime finishedOn;

	public final String NEW = "new";
	public final String RESUMED = "resumed";
	public final String PAUSED = "paused";
	public final String LOST = "lost";
	public final String WON = "won";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalTime startedOn) {
		this.startedOn = startedOn;
	}

	public LocalTime getFinishedOn() {
		return finishedOn;
	}

	public void setFinishedOn(LocalTime finishedOn) {
		this.finishedOn = finishedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentBoard() {
		return currentBoard;
	}

	public void setCurrentBoard(String currentBoard) {
		this.currentBoard = currentBoard;
	}

	public String getSolutionBoard() {
		return solutionBoard;
	}

	public void setSolutionBoard(String solutionBoard) {
		this.solutionBoard = solutionBoard;
	}

	public GameResponse toResponse() {
		GameResponse gameResponse = new GameResponse();

		gameResponse.setId(id);
		gameResponse.setStatus(status);
		gameResponse.setStartedOn(startedOn);
		gameResponse.setFinishedOn(finishedOn);
		gameResponse.setBoard(currentBoard);

		return gameResponse;
	}

}
