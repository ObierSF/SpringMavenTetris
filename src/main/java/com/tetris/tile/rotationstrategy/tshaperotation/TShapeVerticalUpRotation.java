package com.tetris.tile.rotationstrategy.tshaperotation;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class TShapeVerticalUpRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.T) && rotationVariant.equals(RotationVariant.VERTICALUP);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.UPPER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LOWER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.LOWER);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LEFT) != null && !fields.get(2).isNeighbourPlacedField(Neighbour.LEFT);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.UPPER));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.LOWER));
        fields.set(3, getSecond(fields).getNeighbour(Neighbour.LEFT));
    }
}
