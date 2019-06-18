package com.test.amazons.Amazons.Model;

public class Tile {

    private Color color;
    private Position position;

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

    @Override
    public String toString() {
        return "Tile{" +
                "position=" + position.toString() +
                ", type=" + color +
                '}';
    }

}
