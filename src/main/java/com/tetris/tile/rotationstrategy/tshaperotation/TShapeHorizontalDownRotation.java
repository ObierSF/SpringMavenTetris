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
public class TShapeHorizontalDownRotation extends RotationStrategy {
    @Override
    public boolean validate(Shape shape, RotationVariant rotationVariant) {
        return shape.equals(Shape.T) && rotationVariant.equals(RotationVariant.HORIZONTALDOWN);
    }

    @Override
    protected boolean isFirstPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.RIGHT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.RIGHT);
    }

    @Override
    protected boolean isThrirdPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.LEFT) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.LEFT);
    }

    @Override
    protected boolean isForthPositionAvailable(List<Field> fields) {
        return getSecond(fields).getNeighbour(Neighbour.UPPER) != null && !getSecond(fields).isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        fields.set(0, getSecond(fields).getNeighbour(Neighbour.RIGHT));
        fields.set(2, getSecond(fields).getNeighbour(Neighbour.LEFT));
        fields.set(3, getSecond(fields).getNeighbour(Neighbour.UPPER));
    }
}
