package com.game.snakeladder.entities;

public class Player {
    private int playerId;
    private String playerName;
    private int playerCurrentState;

    public Player(int playerId, String playerName, int playerCurrentState) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerCurrentState = playerCurrentState;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerCurrentState() {
        return playerCurrentState;
    }

    public void setPlayerCurrentState(int playerCurrentState) {
        this.playerCurrentState = playerCurrentState;
    }
}
