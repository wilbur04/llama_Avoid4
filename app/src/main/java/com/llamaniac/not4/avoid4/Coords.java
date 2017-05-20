package com.llamaniac.not4.avoid4;

/**
 * Created by Tom on 20/05/2017.
 */

class Coords {
    private int x, y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords getCoords() {
        return this;
    }
}
