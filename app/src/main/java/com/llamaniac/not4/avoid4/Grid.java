package com.llamaniac.not4.avoid4;

/**
 * Created by Wilbur on 17/05/2017.
 */

public class Grid {
    private int activePlayer;
    private int[][] board ;

    public Grid() {
        board = new int[5][5];
        cleanGrid();
        activePlayer =1;
    }

    private void cleanGrid() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[y][x] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * for testing only
     */
    public void printGrid(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                System.out.print(" ["+board[x][y]+"] ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * To swap the players.
     */
    public void changeActivePlayer(){
        if (this.getActivePlayer()==1){
            this.setActivePlayer(2);
        }else if (this.getActivePlayer()==2){
            this.setActivePlayer(1);
        }else{
            this.setActivePlayer(0);
        }
    }

    /**
     *  To get the next empty row in a column.
     * @param col
     * @return
     */
    public int getNextRow(int col){
        for (int i=board.length-1; i>=0; i--){
            if (board[i][col]==0){
                System.out.println("gNR " + i);
                return i;
            }
        }
        return -1;
    }

    public boolean columnIsFull(int col){
       if (getNextRow(col)==-1){
           System.out.println(board.length-1);
           return true;
       }else{
           return false;
       }
    }

    /**
     *  To add to the next empty row in a column
     * @param col
     */
    public void add(int col){
        if (!columnIsFull(col)) {
            board[getNextRow(col)][col] = this.getActivePlayer();
            this.changeActivePlayer();
        } else {
            System.out.println("full");
        }
    }

    public boolean boardIsFull(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[y][x]==0){
                    return false;
                }
            }
        }
        return true;
    }

}

