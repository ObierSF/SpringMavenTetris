package com.tetris.controller.keystrategy;

import com.tetris.controller.MoveController;
import com.tetris.tile.move.Move;

import java.awt.event.KeyEvent;

/**
 * Created by User on 11.04.2016.
 */
public class RightArrowStrategy implements KeyStrategy {
    public boolean validate(int pressedKey) {
        return pressedKey == KeyEvent.VK_RIGHT;
    }

    public void takeAction(MoveController moveController) {
        moveController.moveTile(Move.RIGHT);
    }
}
