package com.llamaniac.not4.avoid4;

import java.util.Random;

/**
 * Created by Tom on 18/05/2017.
 */

public class AI {
    private Random rand;
    private Grid g;

    public AI() {
        rand = new Random();
        g = RobotActivity.game;
    }

    public void makeMove() {

        int tempCol = getRandom(0, 4);
        while (!g.add(tempCol)) {
            tempCol = getRandom(0, 4);
        }

    }

    private int getRandom(int min, int max) {
        int num = rand.nextInt(max - min + 1) + min;
        return num;
    }
}
