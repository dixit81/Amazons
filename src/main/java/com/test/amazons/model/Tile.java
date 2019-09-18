package com.test.amazons.model;

import java.util.StringJoiner;

public class Tile {

    private final Colour colour;

    public Tile(final Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tile.class.getSimpleName() + "[", "]")
                .add("colour=" + colour)
                .toString();
    }
}
