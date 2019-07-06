package com.test.amazons.Amazons.Model;

public class Tile {

    private Color color;
    private Position position;
    private boolean onFire;

    public Tile(final Color color, final Position position) {
        this.color = color;
        this.position = position;
    }

    public Tile() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public boolean isOnFire() { return onFire; }

    public void setOnFire(boolean onFire) { this.onFire = onFire; }

    @Override
    public String toString() {
        return "Tile{" +
                "position=" + position.toString() +
                ", type=" + color +
                '}';
    }

}
