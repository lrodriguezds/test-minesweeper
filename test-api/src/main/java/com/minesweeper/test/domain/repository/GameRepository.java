package com.minesweeper.test.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.minesweeper.test.domain.Game;

/**
 * JPA Repository used to access the Game Entity
 *
 */
public interface GameRepository extends CrudRepository<Game,Integer> {
    
}