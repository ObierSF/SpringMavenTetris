package com.tetris.controller;

import com.tetris.controller.keystrategy.KeyCreator;
import com.tetris.controller.keystrategy.KeyStrategy;
import com.tetris.view.GameView;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * Created by User on 11.04.2016.
 */
@Service
public class KeyController implements KeyListener {
    @Autowired
    private KeyCreator keyCreator;
    @Autowired
    private MoveController moveController;

    public void keyPressed(KeyEvent keyEvent) {
        try {
            KeyStrategy keyStrategy;
            int keyCode = keyEvent.getKeyCode();
            keyStrategy = keyCreator.getKey(keyCode);
            keyStrategy.takeAction(moveController);
            //gameView.repaint();
        } catch (Exception e) {
            System.out.println("Key exception: " + e);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
