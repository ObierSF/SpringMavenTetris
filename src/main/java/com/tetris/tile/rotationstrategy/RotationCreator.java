package com.tetris.tile.rotationstrategy;

import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.ishaperotation.*;
import com.tetris.tile.rotationstrategy.jshaperotation.*;
import com.tetris.tile.rotationstrategy.lshaperotation.*;
import com.tetris.tile.rotationstrategy.sshaperotation.*;
import com.tetris.tile.rotationstrategy.tshaperotation.*;
import com.tetris.tile.rotationstrategy.zshaperotation.*;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class RotationCreator {
    @SuppressWarnings("unchecked")
    private static final List<RotationStrategy> rotationStrategy =
            Collections.unmodifiableList(Arrays.<RotationStrategy>asList(
                    new IShapeHorizontalDownRotation(), new IShapeHorizontalUpRotation(), new IShapeVerticalDownRotation(), new IShapeVerticalUpRotation(),
                    new JShapeHorizontalDownRotation(), new JShapeHorizontalUpRotation(), new JShapeVerticalDownRotation(), new JShapeVerticalUpRotation(),
                    new LShapeHorizontalDownRotation(), new LShapeHorizontalUpRotation(), new LShapeVerticalDownRotation(), new LShapeVerticalUpRotation(),
                    new SShapeHorizontalDownRotation(), new SShapeHorizontalUpRotation(), new SShapeVerticalDownRotation(), new SShapeVerticalUpRotation(),
                    new TShapeHorizontalDownRotation(), new TShapeHorizontalUpRotation(), new TShapeVerticalDownRotation(), new TShapeVerticalUpRotation(),
                    new ZShapeHorizontalDownRotation(), new ZShapeHorizontalUpRotation(), new ZShapeVerticalDownRotation(), new ZShapeVerticalUpRotation()));

    public RotationStrategy getRotation(Shape shape, RotationVariant rotationVariant) throws Exception {
        for (RotationStrategy strategy : rotationStrategy) {
            if (strategy.validate(shape, rotationVariant)) {
                return strategy;
            }
        }
        throw new RotationException();
    }
}
