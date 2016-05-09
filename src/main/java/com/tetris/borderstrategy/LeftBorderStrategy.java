package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class LeftBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > 0 && position < (width * height) - width && position % width == 0);
    }

    public Border getBorder() {
        return Border.LEFT;
    }
}
