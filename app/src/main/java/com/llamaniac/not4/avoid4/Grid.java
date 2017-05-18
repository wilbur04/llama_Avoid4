package com.llamaniac.not4.avoid4;

/**
 * Created by Wilbur on 17/05/2017.
 */

public class Grid {
    private int activePlayer;
    private int[][] board ;
    private boolean player1lost = false;
    private boolean player2lost = false;

    public Grid() {
        board = new int[5][5];
        activePlayer = 1;
        cleanGrid();
    }

    public boolean getPlayer1lost() {
        return player1lost;
    }
    public boolean getPlayer2lost() {
        return player2lost;
    }

    private void cleanGrid() {
        player1lost = false;
        player2lost = false;
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
        System.out.println("-------------------");
    }

    /**
     * To swap the players.
     */
    public void changeActivePlayer() {
        if (this.getActivePlayer() == 1) {
            this.setActivePlayer(2);
        } else {
            this.setActivePlayer(1);
        }
    }

    /**
     *  To get the next empty row in a column.
     * @param col
     * @return
     */
    public int getNextRow(int col) {
        for (int i = board.length-1; i >= 0; i--){
            if (board[i][col] == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean columnIsFull(int col) {
        return getNextRow(col) == -1;
    }

    /**
     *  To add to the next empty row in a column
     * @param col
     */
    public void add(int col) {
        if (!columnIsFull(col)) {
            board[getNextRow(col)][col] = this.getActivePlayer();
            if (p1HasLost()) {
                System.out.println("Player1 lost");
            } else if (p2HasLost()) {
                System.out.println("Player2 lost");
            } else {
                this.changeActivePlayer();
            }
        } else {
            //todo:  what happens when it is full?
            System.out.println("full");
        }
    }

    public boolean boardIsFull() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[y][x]==0){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean p1HasLost() {
        if (searchHorizontalLost() == 1) {
            player1lost = true;
            return true;
        }

        if (searchVerticalLost() == 1) {
            player1lost = true;
            return true;
        }

        if (checkTLBR() == 1) {
            player1lost = true;
            return true;
        }
        if (checkBLTR() == 1) {
            player1lost = true;
            return true;
        }
        return false;
    }

    private boolean p2HasLost() {
        if (searchHorizontalLost() == 2) {
            player2lost = true;
            return true;
        }

        if (searchVerticalLost() == 2) {
            player2lost = true;
            return true;
        }

        if (checkTLBR() == 2) {
            player2lost = true;
            return true;
        }
        if (checkBLTR() ==2 ) {
            player2lost = true;
            return true;
        }
        return false;
    }

    private int searchHorizontalLost() {
        int count1 = 0, count2 = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == 1) {
                    count1++;
                    count2 = 0;
                } else if (board[x][y] == 2) {
                    count2++;
                    count1 = 0;
                } else {
                    count1 = 0;
                    count2 = 0;
                }
                if (count1 == 4 ) {
                    return 1;
                }
                else if (count2 == 4) {
                    return 2;
                }
            }
            count1 = 0;
            count2 = 0;
        }
        return 0;
    }


    private int searchVerticalLost() {
        int count1 = 0, count2 = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y=0; y < board.length; y++) {
                if (board[y][x] == 1) {
                    count1++;
                    count2 = 0;
                } else if (board[y][x] == 2) {
                    count2++;
                    count1 = 0;
                } else {
                    count1 = 0;
                    count2 = 0;
                }
                if (count1 == 4 ){
                    return 1;
                }
                else if (count2 == 4){
                    return 2;
                }
            }
            count1 = 0;
            count2 = 0;
        }
        return 0;
    }

    public int checkTLBR() {
        if (board[1][0] == 1) {
            if (board[2][1] == 1) {
                if (board[3][2] == 1) {
                    if (board[4][3] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[1][0] == 2) {
            if (board[2][1] == 2) {
                if (board[3][2] == 2) {
                    if (board[4][3] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[0][1] == 1) {
            if (board[1][2] == 1) {
                if (board[2][3] == 1) {
                    if (board[3][4] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[0][1] == 2) {
            if (board[1][2] == 2) {
                if (board[2][3] == 2) {
                    if (board[3][4] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[0][0] == 1) {
            if (board[1][1] == 1) {
                if (board[2][2] == 1) {
                    if (board[3][3] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[1][1] == 1) {
            if (board[2][2] == 1) {
                if (board[3][3] == 1) {
                    if (board[4][4] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[0][0] == 2) {
            if (board[1][1] == 2) {
                if (board[2][2] == 2) {
                    if (board[3][3] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[1][1] == 2) {
            if (board[2][2] == 2) {
                if (board[3][3] == 2) {
                    if (board[4][4] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    public int checkBLTR() {
        if (board[3][0] == 1) {
            if (board[2][1] == 1) {
                if (board[1][2] == 1) {
                    if (board[0][3] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[3][0] == 2) {
            if (board[2][1] == 2) {
                if (board[1][2] == 2) {
                    if (board[0][3] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[4][1] == 1) {
            if (board[3][2] == 1) {
                if (board[2][3] == 1) {
                    if (board[1][4] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[4][1] == 2) {
            if (board[3][2] == 2) {
                if (board[2][3] == 2) {
                    if (board[1][4] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[4][0] == 1) {
            if (board[3][1] == 1) {
                if (board[2][2] == 1) {
                    if (board[1][3] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[4][0] == 2) {
            if (board[3][1] == 2) {
                if (board[2][2] == 2) {
                    if (board[1][3] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        if (board[3][1] == 1) {
            if (board[2][2] == 1) {
                if (board[1][3] == 1) {
                    if (board[0][4] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[3][1] == 2) {
            if (board[2][2] == 2) {
                if (board[1][3] == 2) {
                    if (board[0][4] == 2) {
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
}