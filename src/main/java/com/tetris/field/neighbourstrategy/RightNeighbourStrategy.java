package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;

/**
 * Created by User on 12.04.2016.
 */
public class RightNeighbourStrategy implements NeighbourStrategy {
    public boolean validate(Neighbour neighbour) {
        return neighbour == Neighbour.RIGHT;
    }

    public Field getNeighbour(SurroundingFields surroundingFields) {
        return surroundingFields.right;
    }
}
