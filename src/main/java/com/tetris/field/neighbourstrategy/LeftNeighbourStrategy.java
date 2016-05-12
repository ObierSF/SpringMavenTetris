package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;
import org.springframework.stereotype.Component;

@Component
public class LeftNeighbourStrategy implements NeighbourStrategy {
    public boolean validate(Neighbour neighbour) {
        return neighbour == Neighbour.LEFT;
    }

    public Field getNeighbour(SurroundingFields surroundingFields) {
        return surroundingFields.left;
    }
}
