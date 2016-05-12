package com.tetris.field.neighbourstrategy;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.field.SurroundingFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class NeighbourCreator {
    @Autowired
    private List<NeighbourStrategy> neighbourStrategy;

    public Field getNeighbour(Neighbour neighbour, SurroundingFields surroundingFields) throws Exception {
        for (NeighbourStrategy strategy : neighbourStrategy) {
            if (strategy.validate(neighbour)) {
                return strategy.getNeighbour(surroundingFields);
            }
        }
        throw new NeighbourException();
    }
}
