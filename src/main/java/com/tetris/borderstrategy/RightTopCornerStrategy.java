package com.tetris.borderstrategy;

/**
 * Created by User on 09.03.2016.
 */
public class RightTopCornerStrategy implements BorderStrategy {
    public boolean validate(int width, int height, int position, Border border) {
        return position == width-1;
    }

    public Border getBorder() {
        return Border.RIGHTTOPCORNER;
    }
}