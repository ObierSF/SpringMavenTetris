package com.tetris.tilefactory.startrotationstrategy;

import com.tetris.tile.Tile;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 12.04.2016.
 */
public class StartRotationCreator {
    @SuppressWarnings("unchecked")
    private static final List<StartRotationStrategy> StartRotationStrategy =
            Collections.unmodifiableList(Arrays.<StartRotationStrategy>asList(
                    new HorizontalDownRotation(), new HorizontalUpRotation(),
                    new VerticalDownRotation(), new VerticalUpRotation()));

    public void setStartRotation(RotationVariant rotationVariant,Tile tile) {
        for (StartRotationStrategy strategy : StartRotationStrategy) {
            if (strategy.validate(rotationVariant)) {
                strategy.rotate(tile);
            }
        }
    }
}
