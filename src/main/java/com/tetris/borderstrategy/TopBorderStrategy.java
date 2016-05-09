package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class TopBorderStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return (position > 0 && position < width-1);
    }

    public Border getBorder() {
        return Border.TOP;
    }
}
