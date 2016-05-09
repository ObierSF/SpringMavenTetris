package com.tetris.tilefactory.startrotationstrategy;

import com.tetris.tile.Tile;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

/**
 * Created by User on 12.04.2016.
 */
public class VerticalUpRotation implements StartRotationStrategy {
    public boolean validate(RotationVariant rotationVariant) {
        return rotationVariant == RotationVariant.VERTICALUP;
    }

    public void rotate(Tile tile) {

    }
}
