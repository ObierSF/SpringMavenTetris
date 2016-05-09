package com.tetris.controller;

import com.tetris.Board;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by User on 12.04.2016.
 */
@Service
public class ScoreObserver implements Observer {
    private final int width = 10;
    private final int rowValue = 100;
    @Getter private int score;
    @Getter private List<Integer> rows;

    public ScoreObserver() {
        rows = new LinkedList<Integer>();
    }

    public void init(BoardController boardController) {
        boardController.addObserver(this);
    }

    public void sumScore() {
        for (Integer row : rows) {
            score += rowValue;
        }
    }

    public void update(Observable o, Object arg) {
        int position = (Integer) arg;
        for (Integer row : rows) {
            if (row == (position / width)) {
                return;
            }
        }
        rows.add(position / width);
    }
}