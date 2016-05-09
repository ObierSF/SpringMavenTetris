package com.tetris.tile;

import com.tetris.Board;
import com.tetris.field.Field;
import java.awt.Color;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class JShapeTile extends Tile {

    public JShapeTile(Board board) {
        super(board);
        color = Color.GREEN;
        shape = Shape.J;
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(25));
        fields.add(board.getField(24));
    }
}
