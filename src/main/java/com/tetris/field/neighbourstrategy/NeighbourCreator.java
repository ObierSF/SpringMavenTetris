package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 12.04.2016.
 */
public class NeighbourCreator {
    @SuppressWarnings("unchecked")
    private static final List<NeighbourStrategy> neighbourStrategy =
            Collections.unmodifiableList(Arrays.<NeighbourStrategy>asList(
                    new LeftNeighbourStrategy(), new RightNeighbourStrategy(),
                    new UpperNeighbourStrategy(), new LowerNeighbourStrategy()));

    public Field getNeighbour(Neighbour neighbour, SurroundingFields surroundingFields) throws Exception {
        for (NeighbourStrategy strategy : neighbourStrategy) {
            if (strategy.validate(neighbour)) {
                return strategy.getNeighbour(surroundingFields);
            }
        }
        throw new NeighbourException();
    }
}
