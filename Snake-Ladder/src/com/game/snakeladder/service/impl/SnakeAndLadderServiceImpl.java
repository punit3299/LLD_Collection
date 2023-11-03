package com.game.snakeladder.service.impl;

import com.game.snakeladder.constants.GameConstants;
import com.game.snakeladder.entities.Board;
import com.game.snakeladder.entities.Dice;
import com.game.snakeladder.entities.Ladder;
import com.game.snakeladder.entities.Player;
import com.game.snakeladder.entities.Snake;
import com.game.snakeladder.service.SnakeAndLadderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SnakeAndLadderServiceImpl implements SnakeAndLadderService {


    @Override
    public Board initializeBoard(Map<Integer, Integer> snakeDetails, Map<Integer, Integer> ladderDetails) {

        // Initializing Board
        Board board = Board.getInstance();

        //Initializing Snakes
        snakeDetails.forEach((start, end)->{
            Snake snake = new Snake(start, end);
            board.getSnakes().add(snake);
        });

        //Initializing Ladders
        ladderDetails.forEach((start, end)->{
            Ladder ladder = new Ladder(start, end);
            board.getLadders().add(ladder);
        });

        return board;
    }

    @Override
    public void startGame(Board board, List<String> players) {

        Map<Integer, Player> playersMap = new HashMap<>();

        //Initializing Players
        for(int i=0; i < players.size(); i++){
            Player player = new Player(i+1, players.get(i), GameConstants.PLAYER_INITIAL_POSITION);
            playersMap.put(player.getPlayerId(), player);
        }

        //Initializing Dice
        Dice dice = Dice.getInstance();

        int counter = 1;

        while(counter > 0) {
            int currentPlayerId = counter%2 + 1;
            int rolledValue = dice.getRollValue();
            int currentPosition = playersMap.get(currentPlayerId).getPlayerCurrentState();
            String playerName = playersMap.get(currentPlayerId).getPlayerName();
            int newPosition = currentPosition + rolledValue;

            int tempNewPosition = newPosition;

            //checking snake bite
            Optional<Integer> snakeEnd = board.getSnakes().stream()
                    .filter(snake -> snake.getStart() == tempNewPosition)
                    .map(Snake::getEnd)
                    .findFirst();

            if(snakeEnd.isPresent()){
                newPosition = snakeEnd.get();
            }

            //checking ladder bite
            Optional<Integer> ladderEnd = board.getLadders().stream()
                    .filter(ladder -> ladder.getStart() == tempNewPosition)
                    .map(snake -> snake.getEnd())
                    .findFirst();

            if(ladderEnd.isPresent()){
                newPosition = ladderEnd.get();
            }

            System.out.println(playerName + " rolled a " + rolledValue + " and moved from " + currentPosition + " to " + newPosition);

            if(newPosition >= board.getTotalCells()){
                System.out.println(playerName + " wins the game");
                newPosition = board.getTotalCells();
                counter=-1;
            }

            playersMap.get(currentPlayerId).setPlayerCurrentState(newPosition);
            counter++;
        }
    }
}
