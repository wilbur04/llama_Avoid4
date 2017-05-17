package com.llamaniac.not4.avoid4;

import java.lang.reflect.Array;

/**
 * Created by Wilbur on 17/05/2017.
 */

public class Grid {
    private int activePlayer;
    private  Array[][] board ;

    public Grid() {
        //todo : initiate
    }

    public Array[][] getBoard() {
        return board;
    }

    public void setBoard(Array[][] board) {
        this.board = board;
    }


    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }



}
