package com.game.snakeladder.service;

import com.game.snakeladder.entities.Board;

import java.util.List;
import java.util.Map;

public interface SnakeAndLadderService {

    Board initializeBoard(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders);
    void startGame(Board board, List<String> players);
}
