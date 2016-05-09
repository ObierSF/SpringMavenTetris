package com.tetris.tile.move;

import com.tetris.field.Field;
import com.tetris.field.Neighbour;

import java.util.List;

/**
 * Created by User on 12.04.2016.
 */
public class UpStrategy extends MoveStrategy {
    @Override
    public boolean validate(Move move) {
        return move == Move.UP;
    }

    @Override
    public boolean isFieldOnSideAvailable(Field field) {
        return field.getNeighbour(Neighbour.UPPER) != null && !field.isNeighbourPlacedField(Neighbour.UPPER);
    }

    @Override
    public void setUpNewFields(List<Field> fields) {
        for (int i=0; i<fields.size(); i++) {
            if (fields.get(i) != null && fields.get(i).getNeighbour(Neighbour.UPPER) != null) {
                fields.set(i, fields.get(i).getNeighbour(Neighbour.UPPER));
            } else {
                fields.set(i, null);
            }
        }
    }
}
