package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class LeftTopCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == 0;
    }

    public Border getBorder() {
        return Border.LEFTTOPCORNER;
    }
}
