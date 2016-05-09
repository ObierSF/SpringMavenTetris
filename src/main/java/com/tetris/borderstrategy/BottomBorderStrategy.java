package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class BottomBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position < (width * height)-1 && position > (width * height) - width);
    }

    public Border getBorder() {
        return Border.BOTTOM;
    }
}
