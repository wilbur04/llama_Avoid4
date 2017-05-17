package com.llamaniac.not4.avoid4;

/**
 * Created by Wilbur on 17/05/2017.
 */

public class Grid {
    private int activePlayer;
    private int[][] board ;

    public Grid() {
        board = new int[4][4];
        cleanGrid();
    }

    private void cleanGrid() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[x][y] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }


    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }



}
