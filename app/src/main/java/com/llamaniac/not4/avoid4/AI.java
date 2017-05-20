package com.llamaniac.not4.avoid4;

import android.util.Log;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tom on 18/05/2017.
 */
public class AI {
    private Random rand;
    private Grid grid;
    private ArrayList<Integer> checked;

    /**
     * Instantiates a new Ai.
     */
    public AI() {
        rand = new Random();
        grid = RobotActivity.grid;
    }

    /**
     * Function checks 3 potential moves:
     * - Is column full?
     * - Will I die if I go there?
     * - Does going there stop player from dying?
     * <p>
     * Function will select the top priority move.
     */
    public void makeMove() {
        checked = new ArrayList<>();
        reloadChecked();
        int tempNum, tempCol = 0;
        String logMsg = "", availableColumns = "";

        ArrayList<Integer> deadColumns = new ArrayList<>();
        ArrayList<Integer> blockedColumns = new ArrayList<>();

        for (int i = 0; i < grid.getLength(); i++) {
            if (grid.columnIsFull(i)) { //remove all full columns
                checked.remove(Integer.valueOf(i));
            } else if (grid.columnIsDead(i)) { //remove all dead columns
                deadColumns.add(i);
                checked.remove(Integer.valueOf(i));
            } else { //remove all 3 block columns
                grid.changeActivePlayer();
                if (grid.columnIsDead(i)) {
                    blockedColumns.add(i);
                    checked.remove(Integer.valueOf(i));
                }
            }
        }

        if (checked.size() == 0) {
            if (blockedColumns.size() == 0) {
                if (deadColumns.size() == 0) {
                    //no moves available
                    logMsg = "no moves available";
                } else {
                    tempNum = getRandom(0, deadColumns.size() - 1);
                    tempCol = deadColumns.get(tempNum);
                    logMsg = "add to temp column " + tempCol;
                }
            } else {
                tempNum = getRandom(0, blockedColumns.size() - 1);
                tempCol = blockedColumns.get(tempNum);
                logMsg = "add to blocked column " + tempCol;
            }
        } else {
            availableColumns = "Available columns = [";
            for(int i:checked) {
                availableColumns += i+ " ,";
            }
            availableColumns += "]";

            tempNum = getRandom(0, checked.size() - 1);
            tempCol = checked.get(tempNum);
            logMsg = "add to column " + tempCol;
        }

        Log.d(RobotActivity.TAG, availableColumns);
        Log.d(RobotActivity.TAG, logMsg);
        grid.add(tempCol);
        blockedColumns.clear();

    }

    private void reloadChecked() {
        checked.clear();
        for (int i=0; i<5; i++) {
            checked.add(i);
        }
    }

    private int getRandom(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
}
