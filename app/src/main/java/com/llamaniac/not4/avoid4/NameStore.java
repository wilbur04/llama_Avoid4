package com.llamaniac.not4.avoid4;

/**
 * Created by Wilbur on 18/05/2017.
 */

public enum NameStore {
    INSTANCE;

    private String player1Name;
    private String player2name;

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2name;
    }

    public void setPlayer2Name(String player2name) {
        this.player2name = player2name;
    }

}
