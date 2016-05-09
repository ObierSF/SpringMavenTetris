package com.tetris.view.fieldview;


import com.tetris.field.Field;

import java.awt.*;
import java.awt.Color;

/**
 * Created by User on 25.04.2016.
 */
public class ChildFieldView implements FieldView {
    private final Field field;
    private final int width;
    private final int height;
    private final int squareSize = 40;

    public ChildFieldView(int column, int row, Field field) {
        this.field = field;
        height = row * squareSize;
        width = column * squareSize;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(field.getColor());
        graphics.fillRect(width, height, squareSize, squareSize);
    }
}
