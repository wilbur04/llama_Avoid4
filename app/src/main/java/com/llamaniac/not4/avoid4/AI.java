package com.llamaniac.not4.avoid4;

import java.util.Random;

/**
 * Created by Tom on 18/05/2017.
 */

public class AI extends Grid {
    private Random rand;

    AI() {
        rand = new Random();

    }

    private int getRandom(int min, int max) {
        int num = rand.nextInt(max - min + 1) + min;
        return num;
    }
}
