package com.tetris.shapestrategy;

import com.tetris.Board;
import com.tetris.tile.OShapeTile;
import com.tetris.tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class OShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new OShapeTile(board);
    }
}
