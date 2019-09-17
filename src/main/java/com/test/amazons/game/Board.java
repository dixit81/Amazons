package com.test.amazons.game;

import com.test.amazons.model.Colour;
import com.test.amazons.model.Position;
import com.test.amazons.model.Tile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Board {

    // Elwyn says to start off with a 6x6 board

    private final Integer rows;
    private final Integer columns;

    private final List<List<Tile>> boardTiles;

    public Board(@Value("6") final Integer rows,
                 @Value("6") final Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.boardTiles = new ArrayList<>();

        addTilesToBoard();
    }

    private void addTilesToBoard() {
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            this.boardTiles.add(columnIndex, new ArrayList<>());

            addTilesToColumn(columnIndex);
        }
    }

    private void addTilesToColumn(final int columnIndex) {
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            final Position position = Position.of(columnIndex, rowIndex);

            final Colour checkerPatternColour = getCheckerPatternColour(position);

            this.boardTiles.get(columnIndex).add(rowIndex, new Tile(checkerPatternColour));
        }
    }

    private Colour getCheckerPatternColour(final Position position) {
        return (position.getColumn() + position.getRow()) % 2 == 0 ? Colour.BLACK : Colour.WHITE;
    }

    Integer getSize() {
        return rows * columns;
    }

    Tile getTile(final Position position) {
        return boardTiles.get(position.getColumn()).get(position.getRow());
    }
}
