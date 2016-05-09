package com.tetris.tilefactory.startrotationstrategy;

import com.tetris.tile.Tile;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

/**
 * Created by User on 12.04.2016.
 */
public interface StartRotationStrategy {
    boolean validate(RotationVariant rotationVariant);
    void rotate(Tile tile);
}
