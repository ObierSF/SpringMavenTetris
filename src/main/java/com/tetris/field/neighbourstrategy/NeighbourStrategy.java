package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;

/**
 * Created by User on 12.04.2016.
 */
public interface NeighbourStrategy {
    boolean validate(Neighbour neighbour);
    Field getNeighbour(SurroundingFields surroundingFields);
}
