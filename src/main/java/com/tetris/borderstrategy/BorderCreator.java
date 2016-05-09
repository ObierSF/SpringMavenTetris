package com.tetris.borderstrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 30.03.2016.
 */
public class BorderCreator {
    @SuppressWarnings("unchecked")
    private static final List<BorderStrategy> borderStrategy =
            Collections.unmodifiableList(Arrays.<BorderStrategy>asList(
                    new LeftTopCornerStrategy(), new RightTopCornerStrategy(), new LeftBottomCornerStrategy(),
                    new RightBottomCornerStrategy(), new TopBorderStrategy(), new LeftBorderStrategy(),
                    new RightBorderStrategy(), new BottomBorderStrategy(), new NonBorderStrategy()));

    public Border getBorder(int width, int height, int position, Border border) throws Exception {
        for (BorderStrategy strategy : borderStrategy) {
            if (strategy.validate(width, height, position, border)) {
                return strategy.getBorder();
            }
        }
        throw new BorderException();
    }
}
