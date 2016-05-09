package com.tetris.controller.keystrategy;

import com.tetris.controller.MoveController;

import java.awt.event.KeyEvent;

/**
 * Created by User on 11.04.2016.
 */
public interface KeyStrategy {
    boolean validate(int pressedKey);
    void takeAction(MoveController moveController);
}