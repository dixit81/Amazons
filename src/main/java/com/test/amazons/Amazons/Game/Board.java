package com.test.amazons.Amazons.Game;

import com.test.amazons.Amazons.Model.Color;
import com.test.amazons.Amazons.Model.Position;
import com.test.amazons.Amazons.Model.Tile;
import org.springframework.stereotype.Component;

@Component
public class Board {

    // Elwyn says to start off with a 6x6 board

    private int column = 6;
    private int row = 6;

    public Board() {

        setUpBoard();
    }

    public void setUpBoard() {
        System.out.println("Creating the amazons board");

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                Tile tile = new Tile();

                tile.setPosition(new Position(i,j));

                tile.setColor((i + j) % 2 == 0 ? Color.BLACK : Color.WHITE);

                System.out.println(tile.toString());
            }
        }
    }

}
