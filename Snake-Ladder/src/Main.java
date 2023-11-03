import com.game.snakeladder.entities.Board;
import com.game.snakeladder.entities.Ladder;
import com.game.snakeladder.entities.Player;
import com.game.snakeladder.entities.Snake;
import com.game.snakeladder.service.SnakeAndLadderService;
import com.game.snakeladder.service.impl.SnakeAndLadderServiceImpl;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int snakesCount = input.nextInt();
        Map<Integer, Integer> snakeDetails = new HashMap<>();
        while(snakesCount>0){
            int start = input.nextInt();
            int end = input.nextInt();
            snakeDetails.put(start, end);
            snakesCount--;
        }

        int laddersCount = input.nextInt();
        Map<Integer, Integer> ladderDetails = new HashMap<>();
        while(laddersCount>0){
            int start = input.nextInt();
            int end = input.nextInt();
            ladderDetails.put(start, end);
            laddersCount--;
        }

        int playersCount = input.nextInt();
        List<String> playersName = new ArrayList<>();
        while (playersCount>0){
            String playerName = input.next();
            playersName.add(playerName);
            playersCount--;
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderServiceImpl();
        Board board = snakeAndLadderService.initializeBoard(snakeDetails, ladderDetails);
        snakeAndLadderService.startGame(board, playersName);

    }
}