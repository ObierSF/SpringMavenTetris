package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class RightBottomCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == (height * width)-1;
    }

    public Border getBorder() {
        return Border.RIGHTBOTTOMCORNER;
    }
}