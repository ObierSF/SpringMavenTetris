package com.tetris.field;

import com.tetris.field.Field;
import com.tetris.field.neighbourstrategy.NeighbourCreator;

/**
 * Created by User on 17.03.2016.
 */
public class SurroundingFields {
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
            System.out.println("Exception: " + e);
        }
        return null;
    }
}
