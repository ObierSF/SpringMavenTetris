package com.tetris.tile.rotationstrategy.sshaperotation;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class SShapeVerticalUpRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.S) && rotationVariant.equals(RotationVariant.VERTICALUP);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.UPPER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.RIGHT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field rightNeighbour = getSecond(fields).getNeighbour(Neighbour.RIGHT);
        return rightNeighbour.getNeighbour(Neighbour.LOWER) != null && !rightNeighbour.isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.UPPER));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.RIGHT));
        fields.set(3, fields.get(2).getNeighbour(Neighbour.LOWER));
    }
}
