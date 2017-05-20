package com.llamaniac.not4.avoid4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    private HashSet<Coords> losing_locations;



    public Grid() {
        length = 5;
        board = new int[length][length];
        tempBoard = new int[length][length];
        player1lost = false;
        player2lost = false;
        activePlayer = 1;
        cleanGrid();
        losing_locations = new HashSet<Coords>();
    }

    public boolean getPlayer1lost() {
        return player1lost;
    }
    public boolean getPlayer2lost() {
        return player2lost;
    }
    public int getLength() {
        return this.length;
    }

    private void cleanGrid() {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                board[y][x] = 0;
            }
        }
    }

    public HashSet<Coords> getLosingLocations() {
        return this.losing_locations;
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
        HashSet<Coords> p1_locations = new HashSet<>();
        HashSet<Coords> p2_locations = new HashSet<>();
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (board[x][y] == 1) {
                    count1++;
                    count2 = 0;
                    p1_locations.add(new Coords(x, y));
                    p2_locations.clear();
                } else if (board[x][y] == 2) {
                    count2++;
                    count1 = 0;
                    p2_locations.add(new Coords(x, y));
                    p1_locations.clear();
                } else {
                    count1 = 0;
                    count2 = 0;
                    p2_locations.clear();
                    p2_locations.clear();
                }
                if (count1 == 4 ) {
                    losing_locations = p1_locations;
                    return 1;
                }
                else if (count2 == 4) {
                    losing_locations = p2_locations;
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
        HashSet<Coords> p1_locations = new HashSet<>();
        HashSet<Coords> p2_locations = new HashSet<>();
        for (int x = 0; x < length; x++) {
            for (int y=0; y < length; y++) {
                if (board[y][x] == 1) {
                    count1++;
                    count2 = 0;
                    p1_locations.add(new Coords(y, x));
                    p2_locations.clear();
                } else if (board[y][x] == 2) {
                    count2++;
                    count1 = 0;
                    p2_locations.add(new Coords(y, x));
                    p1_locations.clear();
                } else {
                    count1 = 0;
                    count2 = 0;
                    p2_locations.clear();
                    p2_locations.clear();
                }
                if (count1 == 4 ){
                    losing_locations = p1_locations;
                    return 1;
                } else if (count2 == 4){
                    losing_locations = p2_locations;
                    return 2;
                }
            }
            count1 = 0;
            count2 = 0;
        }
        return 0;
    }

    private int checkDiagonalDownwardsLoss() {
        HashSet<Coords> p_locations = new HashSet<>();
        if (board[1][0] == 1) {
            p_locations.add(new Coords(1, 0));
            if (board[2][1] == 1) {
                p_locations.add(new Coords(2, 1));
                if (board[3][2] == 1) {
                    p_locations.add(new Coords(3, 2));
                    if (board[4][3] == 1) {
                        p_locations.add(new Coords(4, 3));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[1][0] == 2) {
            p_locations.add(new Coords(1, 0));
            if (board[2][1] == 2) {
                p_locations.add(new Coords(2, 1));
                if (board[3][2] == 2) {
                    p_locations.add(new Coords(3, 2));
                    if (board[4][3] == 2) {
                        p_locations.add(new Coords(4, 3));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[0][1] == 1) {
            p_locations.add(new Coords(0, 1));
            if (board[1][2] == 1) {
                p_locations.add(new Coords(1, 2));
                if (board[2][3] == 1) {
                    p_locations.add(new Coords(2, 3));
                    if (board[3][4] == 1) {
                        p_locations.add(new Coords(3, 4));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[0][1] == 2) {
            p_locations.add(new Coords(0, 1));
            if (board[1][2] == 2) {
                p_locations.add(new Coords(1, 2));
                if (board[2][3] == 2) {
                    p_locations.add(new Coords(2, 3));
                    if (board[3][4] == 2) {
                        p_locations.add(new Coords(3, 4));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[0][0] == 1) {
            p_locations.add(new Coords(0, 0));
            if (board[1][1] == 1) {
                p_locations.add(new Coords(1, 1));
                if (board[2][2] == 1) {
                    p_locations.add(new Coords(2, 2));
                    if (board[3][3] == 1) {
                        p_locations.add(new Coords(3, 3));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[1][1] == 1) {
            p_locations.add(new Coords(1, 1));
            if (board[2][2] == 1) {
                p_locations.add(new Coords(2, 2));
                if (board[3][3] == 1) {
                    p_locations.add(new Coords(3, 3));
                    if (board[4][4] == 1) {
                        p_locations.add(new Coords(4, 4));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[0][0] == 2) {
            p_locations.add(new Coords(0, 0));
            if (board[1][1] == 2) {
                p_locations.add(new Coords(1, 1));
                if (board[2][2] == 2) {
                    p_locations.add(new Coords(2, 2));
                    if (board[3][3] == 2) {
                        p_locations.add(new Coords(3, 3));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[1][1] == 2) {
            p_locations.add(new Coords(1, 1));
            if (board[2][2] == 2) {
                p_locations.add(new Coords(2, 2));
                if (board[3][3] == 2) {
                    p_locations.add(new Coords(3, 3));
                    if (board[4][4] == 2) {
                        p_locations.add(new Coords(4, 4));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    private int checkDiagonalUpwardsLoss() {
        HashSet<Coords> p_locations = new HashSet<>();
        if (board[3][0] == 1) {
            p_locations.add(new Coords(3, 0));
            if (board[2][1] == 1) {
                p_locations.add(new Coords(2, 1));
                if (board[1][2] == 1) {
                    p_locations.add(new Coords(1, 2));
                    if (board[0][3] == 1) {
                        p_locations.add(new Coords(0, 3));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[3][0] == 2) {
            p_locations.add(new Coords(3, 0));
            if (board[2][1] == 2) {
                p_locations.add(new Coords(2, 1));
                if (board[1][2] == 2) {
                    p_locations.add(new Coords(1, 2));
                    if (board[0][3] == 2) {
                        p_locations.add(new Coords(0, 3));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[4][1] == 1) {
            p_locations.add(new Coords(4, 1));
            if (board[3][2] == 1) {
                p_locations.add(new Coords(3, 2));
                if (board[2][3] == 1) {
                    p_locations.add(new Coords(2, 3));
                    if (board[1][4] == 1) {
                        p_locations.add(new Coords(1, 4));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[4][1] == 2) {
            p_locations.add(new Coords(4, 1));
            if (board[3][2] == 2) {
                p_locations.add(new Coords(3, 2));
                if (board[2][3] == 2) {
                    p_locations.add(new Coords(2, 3));
                    if (board[1][4] == 2) {
                        p_locations.add(new Coords(1, 4));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[4][0] == 1) {
            p_locations.add(new Coords(4, 0));
            if (board[3][1] == 1) {
                p_locations.add(new Coords(3, 1));
                if (board[2][2] == 1) {
                    p_locations.add(new Coords(2, 2));
                    if (board[1][3] == 1) {
                        p_locations.add(new Coords(1, 3));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[4][0] == 2) {
            p_locations.add(new Coords(4, 0));
            if (board[3][1] == 2) {
                p_locations.add(new Coords(3, 1));
                if (board[2][2] == 2) {
                    p_locations.add(new Coords(2, 2));
                    if (board[1][3] == 2) {
                        p_locations.add(new Coords(1, 3));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[3][1] == 1) {
            p_locations.add(new Coords(3, 1));
            if (board[2][2] == 1) {
                p_locations.add(new Coords(2, 2));
                if (board[1][3] == 1) {
                    p_locations.add(new Coords(1, 3));
                    if (board[0][4] == 1) {
                        p_locations.add(new Coords(0, 4));
                        losing_locations = p_locations;
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        p_locations.clear();
        if (board[3][1] == 2) {
            p_locations.add(new Coords(3, 1));
            if (board[2][2] == 2) {
                p_locations.add(new Coords(2, 2));
                if (board[1][3] == 2) {
                    p_locations.add(new Coords(1, 3));
                    if (board[0][4] == 2) {
                        p_locations.add(new Coords(0, 4));
                        losing_locations = p_locations;
                        //2 has lost
                        return 2;
                    }
                }
            }
        }
        return 0;
    }


}