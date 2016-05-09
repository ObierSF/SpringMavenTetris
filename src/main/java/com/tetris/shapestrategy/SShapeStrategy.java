package com.tetris.shapestrategy;

import com.tetris.Board;
import com.tetris.tile.SShapeTile;
import com.tetris.tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class SShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new SShapeTile(board);
    }
}