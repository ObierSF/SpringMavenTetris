package com.tetris.tilefactory.startrotationstrategy;

import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationvariantstrategy.RotationSide;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

/**
 * Created by User on 12.04.2016.
 */
public class VerticalDownRotation implements StartRotationStrategy {
    public boolean validate(RotationVariant rotationVariant) {
        return rotationVariant == RotationVariant.VERTICALDOWN;
    }

    public void rotate(Tile tile) {
        tile.fallForRotation();
        tile.fallForRotation();
        tile.startRotate(RotationSide.RIGHT);
        tile.startRotate(RotationSide.RIGHT);
    }
}
