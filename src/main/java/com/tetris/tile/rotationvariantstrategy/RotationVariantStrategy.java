package com.tetris.tile.rotationvariantstrategy;

import com.tetris.field.Field;

import java.util.List;

/**
 * Created by User on 22.03.2016.
 */
public abstract class RotationVariantStrategy {
    public abstract boolean validate(List<Field> fields, RotationSide side);
    public abstract RotationVariant getRotationVariant();

    boolean isVertical(List<Field> fields) {
        int width = 10;
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return Math.abs(higherFieldPosition - lowerFieldPosition) == width;
    }

    boolean isUpSideDown(List<Field> fields) {
        int higherFieldPosition = fields.get(0).getPosition();
        int lowerFieldPosition = fields.get(1).getPosition();
        return higherFieldPosition > lowerFieldPosition;
    }
}
