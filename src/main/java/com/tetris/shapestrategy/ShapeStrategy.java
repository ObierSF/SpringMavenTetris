package com.tetris.shapestrategy;

import com.tetris.Board;
import com.tetris.tile.Tile;

/**
 * Created by User on 06.03.2016.
 */
public interface ShapeStrategy {
    Tile getTileShape(Board board);
}