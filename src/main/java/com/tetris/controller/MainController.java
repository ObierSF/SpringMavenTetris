package com.tetris.controller;

import com.tetris.tile.move.Move;
import com.tetris.view.TableCreator;
import com.tetris.view.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;


@Service
@EnableScheduling
@PropertySource("config.properties")
public class MainController extends JFrame implements Observer {
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
    private boolean gameOver = false;

    public MainController() {
        super("Tetris");
    }

    @PostConstruct
    private void init(){
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
        if (setNewTile()) {
            gameView.repaint();
            gameLoop();
        }
    }

    private void gameLoop() {
        final Scheduler.Worker worker = Schedulers.newThread().createWorker();
        Subscription subscription = worker.schedulePeriodically(new Action0() {
            public void call() {
                if (!gameOver) {
                    moveController.moveTile(Move.FALL);
                    afterMoveUpdate();
                } else {
                    worker.unsubscribe();
                }
            }
        }, fallTime, fallTime, TimeUnit.MILLISECONDS);
    }

    private void gameOver() {
        gameOver = true;
        tileController.setLastTile();
        gameView.repaint();
        databaseController.addScoreToDatabase(scoreObserver.getScore());
        gameView.setVisible(false);
        JOptionPane.showMessageDialog(null, "Game Over\n Your Score: " + scoreObserver.getScore());
        switchToTableView();
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

    private boolean afterMoveUpdate() {
        gameView.repaint();
        if (!tileController.isFallPossible()) {
            tilePlaceOperation();
            if (!setNewTile()) {
                gameOver();
                return true;
            }
        }
        return false;
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
