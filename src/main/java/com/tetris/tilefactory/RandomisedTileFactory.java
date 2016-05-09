package com.tetris.tilefactory;

import com.tetris.Board;
import com.tetris.shapestrategy.ShapeStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;
import com.tetris.tilefactory.startrotationstrategy.StartRotationCreator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 15.04.2016.
 */
public class RandomisedTileFactory extends TileFactory {
    private StartRotationCreator startRotationCreator;

    @SuppressWarnings("unchecked")
    private static final List<RotationVariant> rotationVariants =
            Collections.unmodifiableList(Arrays.<RotationVariant>asList(
                    RotationVariant.HORIZONTALDOWN, RotationVariant.HORIZONTALUP,
                    RotationVariant.VERTICALDOWN, RotationVariant.VERTICALUP));

    public RandomisedTileFactory(Board board) {
        super(board);
        startRotationCreator = new StartRotationCreator();
    }

    @Override
    public void generateTile() {
        int shapeNumber = rand.nextInt(7);
        int rotationNumber = rand.nextInt(4);
        ShapeStrategy shape = shapeStrategy.get(shapeNumber);
        tile = shape.getTileShape(board);
        startRotationCreator.setStartRotation(rotationVariants.get(rotationNumber), tile);
        tile.moveTileToTop();
    }
}
