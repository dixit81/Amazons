package com.test.amazons.game;

import com.test.amazons.model.Colour;
import com.test.amazons.model.Position;
import com.test.amazons.model.Tile;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void shouldCreateEmptyBoard() {
        final Board emptyBoard = new Board(0, 0);

        assertThat(emptyBoard.getSize(), is(0));
    }

    @Test
    public void shouldCreateSingleBlackSquare() {
        final Board board = new Board(1, 1);

        assertThat(board.getSize(), is(1));
        final Tile tile = board.getTile(Position.of(0, 0));

        assertThat(tile.getColour(), is(Colour.BLACK));
    }

    @Test
    public void shouldCreateBlackWhiteInColumn() {
        final Board board = new Board(1, 2);

        assertThat(board.getSize(), is(2));

        final Tile firstTile = board.getTile(Position.of(0, 0));
        assertThat(firstTile.getColour(), is(Colour.BLACK));

        final Tile secondTile = board.getTile(Position.of(1, 0));
        assertThat(secondTile.getColour(), is(Colour.WHITE));
    }

    @Test
    public void shouldCreateBlackWhiteInRow() {
        final Board board = new Board(2, 1);

        assertThat(board.getSize(), is(2));

        final Tile firstTile = board.getTile(Position.of(0, 0));
        assertThat(firstTile.getColour(), is(Colour.BLACK));

        final Tile secondTile = board.getTile(Position.of(0, 1));
        assertThat(secondTile.getColour(), is(Colour.WHITE));
    }
}