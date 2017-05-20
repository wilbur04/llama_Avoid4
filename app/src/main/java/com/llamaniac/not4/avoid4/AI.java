package com.llamaniac.not4.avoid4;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Tom on 18/05/2017.
 */

public class AI {
    private Random rand;
    private Grid g;
    private int tempBoard[][];
    private ArrayList<Integer> checked;


    public AI() {
        rand = new Random();
        g = RobotActivity.game;
    }


    public void makeMove() {

        checked = new ArrayList<>();
        reloadChecked();
        int tempNum = getRandom(0, checked.size()-1);
        int tempCol = 0;


        //remove all full columns
        for (int i=0; i<5; i++) {
            if (g.columnIsFull(i)) {
                Log.d(RobotActivity.TAG, "going to remove full column " + i);
                checked.remove(new Integer(i));
                Log.d(RobotActivity.TAG, "removed full column " + i);
            }
        }

        ArrayList<Integer> tempChecked = new ArrayList<>();
        //remove all dead columns
        for (int i=0; i<5; i++) {
            if (g.columnIsDead(i)) {
                if (checked.contains(new Integer(i))) {
                    Log.d(RobotActivity.TAG, "going to remove dead column " + i);
                    tempChecked.add(i);
                    checked.remove(new Integer(i));
                    Log.d(RobotActivity.TAG, "removed dead column " + i);
                }
            }
        }

        //remove columns blocking
        ArrayList<Integer> blockedColumns = new ArrayList<>();
        for (int i=0; i<5; i++) {
            g.changeActivePlayer();
            if (g.columnIsDead(i)) {
                if (checked.contains(new Integer(i))) {
                    Log.d(RobotActivity.TAG, "adding to blockedColumns: " + i);
                    blockedColumns.add(i);
                    checked.remove(new Integer(i));
                    Log.d(RobotActivity.TAG, "removed from checked: " + i);
                }
            }
        }


        String logMsg = "";
        if (checked.size() == 0) {
            if (blockedColumns.size() == 0) {
                if (tempChecked.size() == 0) {
                    //no moves available
                } else {
                    tempNum = getRandom(0, tempChecked.size() - 1);
                    tempCol = tempChecked.get(tempNum);
                    logMsg = "add to temp column " + tempCol;
                }
            } else {
                tempNum = getRandom(0, blockedColumns.size() - 1);
                tempCol = blockedColumns.get(tempNum);
                logMsg = "add to blocked column " + tempCol;
            }
        } else {
            String a = "Available columns = [";
            for(int i:checked) {
                a += i+ " ,";
            }
            Log.d(RobotActivity.TAG, a+"]");

            tempNum = getRandom(0, checked.size() - 1);
            tempCol = checked.get(tempNum);
            logMsg = "add to column " + tempCol;
        }


        Log.d(RobotActivity.TAG, logMsg);
        g.add(tempCol);
        blockedColumns.clear();

    }

    private void reloadChecked() {
        checked.clear();
        for (int i=0; i<5; i++) {
            checked.add(i);
        }
    }

    private int getRandom(int min, int max) {
        int num = rand.nextInt(max - min + 1) + min;
        return num;
    }
}
