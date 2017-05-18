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
        activePlayer = 1;
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
        System.out.println("-------------------");
    }

    /**
     * To swap the players.
     */
    public void changeActivePlayer(){
        if (this.getActivePlayer()==1){
            this.setActivePlayer(2);
        }else if (this.getActivePlayer()==2){
            this.setActivePlayer(1);
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
                return i;
            }
        }
        return -1;
    }

    public boolean columnIsFull(int col){
        if (getNextRow(col)==-1){
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
            if (p1HasLost(getNextRow(col),col)){

                //// TODO: 18/05/2017 notify that p1 has lost
                System.out.println("Player1 lost");

            }else if (p1HasLost(getNextRow(col),col)){

                //// TODO: 18/05/2017 notify p2 has lost
                System.out.println("Player2 lost");

            }
            else{
                this.changeActivePlayer();
            }
        } else {
            //todo:  what happens when it is full?
            System.out.println("full");
        }
        printGrid();

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

    public boolean p1HasLost(int row, int col) {
        int count1, count2 = 0;
        searchHorizontalLost();
        if (searchHorizontalLost()==1){
            System.out.println("sussecc");
            return true;
        }

        if (searchVerticalLost()==1){
            System.out.println("sussecc");
            return true;
        }

        if (checkTLBR()==1) {
            System.out.println("1 has lost tlbr");
            return true;
        }
        if (checkBLTR() ==1){
            System.out.println("1 has lost bltr");

            return true;
        }

        return false;
    }

    public boolean p2HasLost(){
        if (searchHorizontalLost()==2){
            System.out.println("sussecc2");
            return true;
        }
        else if (searchVerticalLost()==2){
            System.out.println("sussecc2");
            return true;
        }else  if (checkBLTR()==2){
            System.out.println("sussecc2 bltr");
            return  true;
        }else if (checkTLBR() ==2){
            System.out.println("sussecc2");
            return true;
        }
        return false;
    }

    public int searchHorizontalLost(){
        int count1 = 0, count2 = 0;

        for (int x=0; x<board.length; x++){
            for (int y=0; y<board.length; y++){
                if (board[x][y]==1){
                    count1++;
                    count2=0;
                }else if (board[x][y]==2){
                    count2++;
                    count1=0;
                } else {
                    count1=0;
                    count2=0;
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


    public int searchVerticalLost(){
        int count1 = 0, count2 = 0;

        for (int x=0; x<board.length; x++){
            for (int y=0; y<board.length; y++){
                if (board[y][x]==1){
                    count1++;
                    count2=0;
                }else if (board[y][x]==2){
                    count2++;
                    count1=0;
                } else {
                    count1=0;
                    count2=0;
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
                    if (board[0][1] == 1) {
                        //1 has lost
                        return 1;
                    }
                }
            }
        }
        if (board[3][0] == 2) {
            if (board[2][1] == 2) {
                if (board[1][2] == 2) {
                    if (board[0][1] == 2) {
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

