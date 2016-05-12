package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;
import org.springframework.stereotype.Component;

@Component
public class UpperNeighbourStrategy implements NeighbourStrategy {
    public boolean validate(Neighbour neighbour) {
        return neighbour == Neighbour.UPPER;
    }

    public Field getNeighbour(SurroundingFields surroundingFields) {
        return surroundingFields.upper;
    }
}
