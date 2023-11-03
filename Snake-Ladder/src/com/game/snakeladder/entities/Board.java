package com.game.snakeladder.entities;

import com.game.snakeladder.constants.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static Board board = null;
    private int totalCells;
    List<Snake> snakes;
    List<Ladder> ladders;

    private Board(){
        totalCells = GameConstants.BOARD_TOTAL_CELLS;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public static Board getInstance(){
        if(board == null){
            board = new Board();
        }
        return board;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public void setTotalCells(int totalCells) {
        this.totalCells = totalCells;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}
