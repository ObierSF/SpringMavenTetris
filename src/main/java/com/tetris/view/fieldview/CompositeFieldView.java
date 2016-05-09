package com.tetris.view.fieldview;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
public class CompositeFieldView implements FieldView {
    private List<FieldView> fieldViews;

    public CompositeFieldView() {
        fieldViews = new ArrayList<FieldView>();
    }

    public void draw(Graphics graphics) {
        for (FieldView fieldView : fieldViews) {
            fieldView.draw(graphics);
        }
    }

    public void addField(FieldView fieldView) {
        fieldViews.add(fieldView);
    }
}
