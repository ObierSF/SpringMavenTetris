package com.tetris.controller;

import com.tetris.tile.move.Move;
import com.tetris.view.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Thread.sleep;

/**
 * Created by User on 16.04.2016.
 */
@Service
@PropertySource("config.properties")
public class Controller extends JFrame implements Observer {
    @Value("1000")
    private int fallTime;
    @Autowired
    private BoardController boardController;
    @Autowired
    private ScoreObserver scoreObserver;
    @Autowired
    private TileController tileController;
    @Autowired
    private MoveController moveController;
    @Autowired
    private GameView gameView;
    @Autowired
    private KeyController keyController;
    private boolean isGameOver = false;

    public Controller() {
        super("Tetris");
    }

    @PostConstruct
    private void init() {
        scoreObserver.init(boardController);
        tileController.init(boardController.getBoard());
        moveController.addObserver(this);
        addKeyListener(keyController);
        add(gameView);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void run() {
        try {
            if (setNewTile()) {
                gameView.repaint();
                gameLoop();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }

    private void gameLoop() throws InterruptedException {
        while(!isGameOver) {
            sleep(fallTime);
            moveController.moveTile(Move.FALL);
            afterMoveUpdate();
        }
    }

    private void gameOver() {
        tileController.setLastTile();
        gameView.repaint();
        isGameOver = true;
        System.out.println("Game Over");
    }

    public void update(Observable o, Object arg) {
        afterMoveUpdate();
    }

    private void afterMoveUpdate() {
        gameView.repaint();
        if (!tileController.isFallPossible()) {
            tilePlaceOperation();
            if (!setNewTile()) {
                gameOver();
            }
        }
    }

    public boolean setNewTile() {
        if (tileController.isAddingTilePossible()) {
            tileController.setRandomTile();
            moveController.setTile(tileController.getTile());
            gameView.repaint();
            return true;
        }
        return false;
    }

    private void tilePlaceOperation() {
        boardController.searchForFullRows(tileController.getFields());
        scoreObserver.sumScore();
        boardController.clearFullRows(scoreObserver.getRows());
        tileController.placeTile();
    }
}
