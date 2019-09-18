package com.test.amazons.model;

import java.util.StringJoiner;

public class Position {

    private final Integer column;
    private final Integer row;

    private Position(final Integer column, final Integer row) {
        this.column = column;
        this.row = row;
    }

    public static Position of(final Integer column, final Integer row) {
        return new Position(column, row);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Position.class.getSimpleName() + "[", "]")
                .add("column=" + column)
                .add("row=" + row)
                .toString();
    }
}
