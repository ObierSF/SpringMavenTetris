package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class RightBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > width-1 && position < (height * width)-1 && position % width == 9);
    }

    public Border getBorder() {
        return Border.RIGHT;
    }
}
