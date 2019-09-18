package com.test.amazons.controller;

// TODO add logic to control the game

import com.test.amazons.game.Board;
import org.springframework.stereotype.Component;

@Component
public class GameController {

    public void setUpGame() {
        final Board board = new Board(6, 6);

    }
}
