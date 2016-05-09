package com.tetris.shapestrategy;

import com.tetris.Board;
import com.tetris.tile.JShapeTile;
import com.tetris.tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class JShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new JShapeTile(board);
    }
}
