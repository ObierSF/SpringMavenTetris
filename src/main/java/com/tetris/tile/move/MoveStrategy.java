package com.tetris.tile.move;

import com.tetris.field.Field;

import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public abstract class MoveStrategy {
    public abstract boolean validate(Move move);
    public abstract boolean isFieldOnSideAvailable(Field field);
    public abstract void setUpNewFields(List<Field> fields);

    public boolean isPossible(List<Field> fields) {
        for (Field field : fields) {
            if (!isFieldOnSideAvailable(field)) {
                return false;
            }
        }
        return true;
    }

    private void emptyOldField(List<Field> fields) {
        for (Field field : fields) {
            if (field != null) {
                field.empty();
            }
        }
    }

    public void lastMove(List<Field> fields) {
        setUpNewFields(fields);
    }

    public void move(List<Field> fields) {
        emptyOldField(fields);
        setUpNewFields(fields);
    }
}
