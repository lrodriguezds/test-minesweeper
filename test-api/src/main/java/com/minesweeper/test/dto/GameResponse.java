package com.minesweeper.test.dto;

import java.time.LocalTime;

/**
 * 
 *
 */
public class GameResponse {

	private Integer id;

	private String status;

	private String board;

	private LocalTime startedOn;

	private LocalTime finishedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
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

}
