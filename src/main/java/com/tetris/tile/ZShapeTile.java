package com.tetris.tile;

import com.tetris.Board;
import com.tetris.field.Field;
import java.awt.Color;

import java.util.ArrayList;

/**
 * Created by User on 06.03.2016.
 */
public class ZShapeTile extends Tile {
    public ZShapeTile(Board board) {
        super(board);
        color = Color.ORANGE;
        shape = Shape.Z;
    }

    @Override
    public void setUpFields() {
        fields = new ArrayList<Field>();
        fields.add(board.getField(5));
        fields.add(board.getField(15));
        fields.add(board.getField(14));
        fields.add(board.getField(24));
    }
}