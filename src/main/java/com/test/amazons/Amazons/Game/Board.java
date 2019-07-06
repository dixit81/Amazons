package com.test.amazons.Amazons.Game;

import com.test.amazons.Amazons.Model.Color;
import com.test.amazons.Amazons.Model.Position;
import com.test.amazons.Amazons.Model.Tile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Board {

    // Elwyn says to start off with a 6x6 board

    private int column = 6;
    private int row = 6;

    private Tile[][] tiles;

    public Board() {

        setUpBoard();
    }

    /**
     * Creates the tiles on the board
     */
    public void setUpBoard() {
        System.out.println("Creating the amazons board");

        tiles = new Tile[column][row];

        //Add tiles to board
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                Tile tile = new Tile();

                tile.setPosition(new Position(i,j));

                tile.setColor((i + j) % 2 == 0 ? Color.BLACK : Color.WHITE);

                tiles[i][j] = tile;

                System.out.println(tile.toString());
            }
        }
    }

    /**
     * Get the tiles that would be accessible from the given tiles position.
     * I.e. up/down/side-to-side/diagonal. in the way a queen would move, stopping at the edges of the board,
     * a tile on fire, or a //TODO queen.
     * Note: Does not include the given tile in the list.
     * @param tile The tile in question for accessibility
     * @return The list of accessible tiles from the given tile.
     */
    public List<Tile> getAccessibleTilesFrom(Tile tile) {
        List<Tile> accessibleTiles = new ArrayList<>();
        int tileCol = tile.getPosition().getI();
        int tileRow = tile.getPosition().getJ();

        //We follow a line from the given tile and keep adding tiles until we
        //reach the end of the board or a tile which is on fire.
        //Columns
        for (int i = tileCol + 1; i < column; i++) {
            Tile t = tiles[i][tileRow];
            if (!addTile(accessibleTiles, t)) {
                break;
            }
        }
        for (int i = tileCol - 1; i >= 0; i--) {
            Tile t = tiles[i][tileRow];
            if (!addTile(accessibleTiles, t)) {
                break;
            }
        }

        //Rows
        for (int j = tileRow + 1; j < row; j++) {
            Tile t = tiles[tileCol][j];
            if (!addTile(accessibleTiles, t)) {
                break;
            }
        }
        for (int j = tileRow - 1; j >= 0; j--) {
            Tile t = tiles[tileCol][j];
            if (!addTile(accessibleTiles, t)) {
                break;
            }
        }

        //Diagonals
        //Diagonal \
        int minDimension = column < row ? column : row;
        for (int k = 1; k < minDimension; k++) {
            if (tileCol + k > column || tileRow + k > row || !addTile(accessibleTiles, tiles[tileCol + k][tileRow + k])) {
                break;
            }
        }
        for (int k = 1; k < minDimension; k++) {
            if (tileCol - k < 0 || tileRow - k < 0 || !addTile(accessibleTiles, tiles[tileCol - k][tileRow - k])) {
                break;
            }
        }

        //Diagonal /
        for (int k = 1; k < minDimension; k++) {
            if (tileCol + k > column || tileRow - k < 0 || !addTile(accessibleTiles, tiles[tileCol + k][tileRow - k])) {
                break;
            }
        }
        for (int k = 1; k < minDimension; k++) {
            if (tileCol - k < 0 || tileRow + k > row || !addTile(accessibleTiles, tiles[tileCol - k][tileRow + k])) {
                break;
            }
        }

        return accessibleTiles;
    }

    /**
     * Adds the tile to the given list iff it is not on fire.
     * Exists primarily for readability.
     * @param tiles The list to add a tile to.
     * @param tile The tile to be added.
     * @return True if added.
     */
    private boolean addTile(List<Tile> tiles, Tile tile) {
        if (tile.isOnFire()) { //TODO or contains Queen.
            return false;
        } else {
            tiles.add(tile);
            return true;
        }
    }

    /**
     * Returns the tile in the given location.
     * @param i The Column Number
     * @param j The Row Number
     * @return The tile in the given location.
     */
    public Tile getTile(int i, int j) throws ArrayIndexOutOfBoundsException {
        return tiles[i][j];
    }
}
