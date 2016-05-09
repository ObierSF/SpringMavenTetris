package com.tetris.controller.keystrategy;

import com.tetris.controller.MoveController;
import com.tetris.tile.rotationvariantstrategy.RotationSide;

import java.awt.event.KeyEvent;

/**
 * Created by User on 11.04.2016.
 */
public class UpArrowStrategy implements KeyStrategy {
    public boolean validate(int pressedKey) {
        return pressedKey == KeyEvent.VK_UP;
    }

    public void takeAction(MoveController moveController) {
        moveController.rotateTile(RotationSide.LEFT);
    }
}
