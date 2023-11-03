package com.game.snakeladder.entities;

import com.game.snakeladder.constants.GameConstants;

import java.util.Random;

public class Dice {

    private static Dice dice = null;
    int maxDiceNumber;

    private Dice(){
        maxDiceNumber = GameConstants.DICE_MAX_VALUE;
    }

    public static Dice getInstance(){
        if(dice == null){
            dice = new Dice();
        }
        return dice;
    }

    public int getRollValue(){
        return new Random().nextInt(maxDiceNumber)+1;
    }
}
