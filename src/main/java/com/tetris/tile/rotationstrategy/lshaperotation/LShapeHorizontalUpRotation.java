package com.tetris.tile.rotationstrategy.lshaperotation;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class LShapeHorizontalUpRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.L) && rotationVariant.equals(RotationVariant.HORIZONTALUP);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LEFT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.LEFT);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.RIGHT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field leftNeighbour = getSecond(fields).getNeighbour(Neighbour.LEFT);
        return leftNeighbour.getNeighbour(Neighbour.UPPER) != null && !leftNeighbour.isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.LEFT));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.RIGHT));
        fields.set(3, fields.get(2).getNeighbour(Neighbour.UPPER));
    }
}
