package com.test.amazons.Amazons.Model;

public class Position {

    private int i;
    private int j;

    public Position(final int i, final int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setPosition(final int i, final int j) {
        this.i = i;
        this.j = j;

    }

    /*public void setPosition(final Position position) {
        setPosition(position.i, position.j);
    }*/

    @Override
    public String toString() {
        return "Position{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
