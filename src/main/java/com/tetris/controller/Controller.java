package com.tetris.controller;

import com.tetris.controller.database.TableCreator;
import com.tetris.tile.move.Move;
import com.tetris.view.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Thread.sleep;


@Service
@EnableScheduling
@PropertySource("config.properties")
public class Controller extends JFrame implements Observer {
    private final long fallTime = 1000;
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
    @Autowired
    private DatabaseController databaseController;
    @Autowired
    private TableCreator tableCreator;
    private JScrollPane scrollPane;
    private JButton button;
    private boolean gameOver = false;

    public Controller() {
        super("Tetris");
    }

    @PostConstruct
    private void init(){
        scoreObserver.init(boardController);
        tileController.init(boardController.getBoard());
        moveController.addObserver(this);
        addKeyListener(keyController);
//        JTable table = tableCreator.createTableFromScoreList();
//        scrollPane = new JScrollPane(table);
        add(gameView);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void run() {
        if (setNewTile()) {
            gameView.repaint();
            gameLoop();
        }
    }

    @Scheduled(initialDelay = fallTime, fixedRate = fallTime)
    private void gameLoop() {
        if (!gameOver) {
            moveController.moveTile(Move.FALL);
            afterMoveUpdate();
        }
    }

    private void gameOver() {
        if (!gameOver) {
            gameOver = true;
            tileController.setLastTile();
            gameView.repaint();
            databaseController.addScoreToDatabase(scoreObserver.getScore());
            gameView.setVisible(false);
            JOptionPane.showMessageDialog(null, "Game Over\n Your Score: " + scoreObserver.getScore());
            switchToTableView();
        }
    }

    public void switchToTableView() {
        JTable table = tableCreator.createTableFromScoreList();
        scrollPane = new JScrollPane(table);
        remove(gameView);
        add(scrollPane);
        pack();
        scrollPane.setVisible(true);
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
        tileController.placeTile();
        boardController.clearFullRows(scoreObserver.getRows());
    }
}
