package com.tetris.tile.move;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public class LeftStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move == Move.LEFT;
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getNeighbour(Neighbour.LEFT) != null && !field.isNeighbourPlacedField(Neighbour.LEFT);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        for (int i=0; i<fields.size(); i++) {
            fields.set(i, fields.get(i).getNeighbour(Neighbour.LEFT));
        }
    }
}
