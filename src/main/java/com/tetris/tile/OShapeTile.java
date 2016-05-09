package com.tetris.tile;

import com.tetris.Board;
import com.tetris.field.Field;
import java.awt.Color;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class OShapeTile extends Tile {
    public OShapeTile(Board board) {
        super(board);
        color = Color.BLUE;
        shape = Shape.O;
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(4));
        fields.add(board.getField(5));
        fields.add(board.getField(14));
        fields.add(board.getField(15));
    }
}
