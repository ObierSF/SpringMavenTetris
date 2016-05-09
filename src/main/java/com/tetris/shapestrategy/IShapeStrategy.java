package com.tetris.shapestrategy;

import com.tetris.Board;
import com.tetris.tile.IShapeTile;
import com.tetris.tile.Tile;

/**
 * Created by User on 22.03.2016.
 */
public class IShapeStrategy implements ShapeStrategy {
    public Tile getTileShape(Board board) {
        return new IShapeTile(board);
    }
}
