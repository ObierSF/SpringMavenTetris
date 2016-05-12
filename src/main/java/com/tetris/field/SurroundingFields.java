package com.tetris.field;

import com.tetris.field.neighbourstrategy.NeighbourCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SurroundingFields {
    @Autowired
    private NeighbourCreator neighbourCreator;
    public Field upper;
    public Field right;
    public Field lower;
    public Field left;

    public SurroundingFields() {
        neighbourCreator = new NeighbourCreator();
    }

    public Field getNeighbour(Neighbour neighbour) {
        try {
            return neighbourCreator.getNeighbour(neighbour, this);
        } catch (Exception e) {
            System.out.println("Neighbour exception: " + e);
        }
        return null;
    }
}
