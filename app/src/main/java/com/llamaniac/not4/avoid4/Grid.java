package com.llamaniac.not4.avoid4;

/**
 * Created by Wilbur on 17/05/2017.
 */

public class Grid {
    private int activePlayer;
    private int[][] board ;
    private boolean player1lost;
    private boolean player2lost;
    private int length;
    private int[][] tempBoard;



    public Grid() {
        length = 5;
        board = new int[length][length];
        tempBoard = new int[length][length];
        player1lost = false;
        player2lost = false;
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
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                board[y][x] = 0;
            }
        }
    }

    public void setTempBoard() {
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board.length; j++)
                tempBoard[i][j]=board[i][j];
    }
    public void restoreBoardState() {
        for(int i=0; i<tempBoard.length; i++)
            for(int j=0; j<tempBoard.length; j++)
                board[i][j]=tempBoard[i][j];
        player2lost = false;
        player1lost = false;
        setActivePlayer(2);
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
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
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
    private int getNextRow(int col) {
        for (int i = length-1; i >= 0; i--) {
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
     * @return false if board is full, else true
     */
    public int add(int col) {
        if (!columnIsFull(col)) {
            board[getNextRow(col)][col] = this.getActivePlayer();
            if (hasLost(1)) {
                player1lost = true;
                return 1;
            } else if (hasLost(2)) {
                player2lost = true;
                return 1;
            } else {
                this.changeActivePlayer();
            }
            return 2;
        } return 0;
    }

    public boolean columnIsDead(int column) {
        setTempBoard();
        if (add(column) == 1) {
            restoreBoardState();
            return true;
        }
        restoreBoardState();
        return false;
    }

    public boolean boardIsFull() {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (board[y][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean hasLost(int player) {
        if (checkHorizontalLoss() != player) {
            if (checkVerticalLoss() != player) {
                if (checkDiagonalUpwardsLoss() != player) {
                    if (checkDiagonalDownwardsLoss() != player) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int checkHorizontalLoss() {
        int count1 = 0, count2 = 0;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
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


    private int checkVerticalLoss() {
        int count1 = 0, count2 = 0;
        for (int x = 0; x < length; x++) {
            for (int y=0; y < length; y++) {
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
                } else if (count2 == 4){
                    return 2;
                }
            }
            count1 = 0;
            count2 = 0;
        }
        return 0;
    }

    private int checkDiagonalDownwardsLoss() {
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

    private int checkDiagonalUpwardsLoss() {
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