package com.tetris.controller;

import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * Created by User on 07.04.2016.
 */
@Service
public class MoveController extends Observable {
    @Setter private Tile tile;

    public void moveTile(Move move) {
        tile.move(move);
        notifyAfterMove();
    }

    public void rotateTile(RotationSide rotationSide) {
        tile.rotate(rotationSide);
        notifyAfterMove();
    }

    public void tileFallToBottom() {
        while (tile.move(Move.FALL)) {

        }
        notifyAfterMove();
    }

    private void notifyAfterMove() {
        setChanged();
        notifyObservers();
    }
}
