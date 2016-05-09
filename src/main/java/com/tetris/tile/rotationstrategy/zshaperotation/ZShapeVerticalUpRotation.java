package com.tetris.tile.rotationstrategy.zshaperotation;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.Shape;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;

import java.util.List;

/**
 * Created by User on 05.04.2016.
 */
public class ZShapeVerticalUpRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.Z) && rotationVariant.equals(RotationVariant.VERTICALUP);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.UPPER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LEFT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.LEFT);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        Field leftNeighbour = getSecond(fields).getNeighbour(Neighbour.LEFT);
        return leftNeighbour.getNeighbour(Neighbour.LOWER) != null && !leftNeighbour.isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.UPPER));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.LEFT));
        fields.set(3, fields.get(2).getNeighbour(Neighbour.LOWER));
    }
}
